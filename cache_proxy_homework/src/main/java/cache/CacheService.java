package cache;

import enums.cacheType;
import myannotation.CacheMethod;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CacheService implements ICacheService {
    private CacheMemory cacheMemory = new CacheMemory();
    private CacheFile cacheFile;

    public CacheService(Path dirCache) {
        cacheFile = new CacheFile( dirCache );
    }

    @Override
    public Optional<Object> tryReadingFromCache(Method method, Object[] args) {
        Object result = null;
        Object[] cachesArgs = getAnnotationMethodParams( method, args );


        if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.FILE) {
            System.out.println( "Попытка чтения в кеше (файл)" );

            Optional<Data> res = cacheFile.get( method.getName(), args );

            Data data = res.orElse( null );
            if (data != null) {
                for (Object arg : cachesArgs) {
                    boolean b = false;
                    Object[] dataArgs = data.getArgs();

                    for (int i = 0; i < dataArgs.length; i++) {

                        if (dataArgs[i].equals( arg )) {
                            b = true;
                            break;
                        }
                    }

                    if (b == false) {
                        System.out.println( "Файлы изменились, поэтому не будем читать из кеша, то есть посчитаем и перезапишим" );
                        return Optional.ofNullable( null );
                    }
                }

                System.out.println("Данные прочитаны из кеша");
                result = data.getInvoke();
            }else {
                System.out.println("Данных нет в кеше");
            }

        } else if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.MEMORY) {

            System.out.println( "Попытка чтение в кеше (память)" );
            Optional<Data> res = cacheMemory.get( method.getName(), args );
            Data data = res.orElse( null );

            if (data != null) {
                for (Object arg : cachesArgs) {
                    boolean b = false;
                    Object[] dataArgs = data.getArgs();

                    for (int i = 0; i < dataArgs.length; i++) {

                        if (dataArgs[i].equals( arg )) {
                            b = true;
                            break;
                        }
                    }

                    if (b == false) {
                        System.out.println( "Файлы изменились, поэтому не будем читать из кеша, то есть посчитаем и перезапишим" );
                        return Optional.ofNullable( null );
                    }
                }

                System.out.println("Данные прочитаны из кеша");
                result = data.getInvoke();
            }
            else {
                System.out.println("Данных нет в кеше");
            }

        }

        return Optional.ofNullable( result );
    }

    @Override
    public void tryWritingCache(Method method, Object[] args, Object invoke) {
        if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.FILE) {
            System.out.println( "Запись кеша в файл" );
            cacheFile.set( method.getName(), args, invoke );
        } else if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.MEMORY) {
            System.out.println( "Запись кеша в память" );
            cacheMemory.set( method.getName(), args, invoke );
        }
    }

    private Object[] getAnnotationMethodParams(Method method, Object[] args) {

        Class[] classList = method.getAnnotation( CacheMethod.class ).identityBy();
        List<Object> cachesArgs = new ArrayList<>();
        for (Class c : classList) {
            Arrays.stream( args ).forEach( o -> {
                if (o.getClass().equals( c ))
                    cachesArgs.add( o );
            } );
        }

        return cachesArgs.toArray();
    }
}


