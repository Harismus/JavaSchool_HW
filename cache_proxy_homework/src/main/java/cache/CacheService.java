package cache;

import enums.cacheType;
import myannotation.CacheMethod;
import zip.ZipService;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;


public class CacheService implements ICacheService {
    private CacheMemory cacheMemory = new CacheMemory();
    private CacheFile cacheFile;
    private ZipService zipService;

    public CacheService(Path dirCache) {
        cacheFile = new CacheFile(dirCache);
        zipService = new ZipService(dirCache);
    }

    private Object checkData(Optional<Data> res, Object[] cachesArgs) {
        Object result = null;
        Data data = res.orElse(null);
        if (data != null) {
            for (Object arg : cachesArgs) {
                boolean b = false;
                Object[] dataArgs = data.getArgs();
                for (int i = 0; i < dataArgs.length; i++) {
                    if (dataArgs[i].equals(arg)) {
                        b = true;
                        break;
                    }
                }
                if (b == false) {
                    System.out.println("Аргументы изменились, поэтому не будем читать из кеша, то есть посчитаем и перезапишим");
                    return null;
                }
            }
            System.out.println("Данные прочитаны из кеша");
            result = data.getInvoke();
        } else {
            System.out.println("Данных нет в кеше");
        }

        return result;
    }

    @Override
    public Optional<Object> tryReadingFromCache(Method method, Object[] args) {
        Object result = null;
        Object[] cachesArgs = getAnnotationMethodParams(method, args);

        if (method.getAnnotation(CacheMethod.class).savedPlace() == cacheType.FILE) {
            System.out.println("Попытка чтения в кеше (файл)");
            String fileNamePrefix = method.getAnnotation(CacheMethod.class).fileNamePrefix();
            String fileName = fileNamePrefix.length() > 0 ? fileNamePrefix : method.getName();
            Optional<Data> res = cacheFile.get(fileName, args);
            result = checkData(res, cachesArgs);

        } else if (method.getAnnotation(CacheMethod.class).savedPlace() == cacheType.MEMORY) {
            System.out.println("Попытка чтение в кеше (память)");
            Optional<Data> res = cacheMemory.get(method.getName(), args);
            result = checkData(res, cachesArgs);
        } else {
            System.out.println("Данных нет в кеше");
        }

        return Optional.ofNullable(result);
    }

    @Override
    public void tryWritingCache(Method method, Object[] args, Object invoke) {
        if (method.getAnnotation(CacheMethod.class).savedPlace() == cacheType.FILE) {
            System.out.println("Запись кеша в файл");
            System.out.println("invoke = " + invoke);

            if (method.getAnnotation(CacheMethod.class).sizeReturn() > 1 //!< ограничения количества кешируемых значений, если List
                    && method.getReturnType() == java.util.List.class) {
                List<Object> list = (List<Object>) invoke;
                int size = method.getAnnotation(CacheMethod.class).sizeReturn();
                Object[] array = Arrays.copyOf(list.toArray(), size);
                list.clear();
                list.addAll(Arrays.asList(array));

                for (Object o : list) {
                    System.out.println("o = " + o);
                }

                invoke = list;

            }

            String fileNamePrefix = method.getAnnotation(CacheMethod.class).fileNamePrefix();
            String fileName = fileNamePrefix.length() > 0 ? fileNamePrefix : method.getName();
            cacheFile.set(fileName, args, invoke);

            if (method.getAnnotation(CacheMethod.class).isZip()) { //!< архивация, если есть
                zipService.zip(fileName + ".cache", fileName + ".zip");
            }

        } else if (method.getAnnotation(CacheMethod.class).savedPlace() == cacheType.MEMORY) {
            System.out.println("Запись кеша в память");
            cacheMemory.set(method.getName(), args, invoke);
        }
    }

    private Object[] getAnnotationMethodParams(Method method, Object[] args) {
        Class[] classList = method.getAnnotation(CacheMethod.class).identityBy();
        List<Object> cachesArgs = new ArrayList<>();
        for (Class c : classList) {
            Arrays.stream(args).forEach(o -> {
                if (o.getClass().equals(c))
                    cachesArgs.add(o);
            });
        }
        return classList.length != 0 ? cachesArgs.toArray() : args; //!< если список аннотаций по параметрам метода пуст, то берем все аргументы
    }
}


