import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Optional;


public class CalculatorInvocationHandler implements InvocationHandler {
    private Object delegate;
    long before = 0;
    long after = 0;
    CacheMemory cacheMemory = new CacheMemory();
    CacheFile cacheFile = new CacheFile();

    public CalculatorInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent( CacheMethod.class )) { //!< если кеш аннотация, то проверим наличия в кеше результата
            Optional<Object> result = tryReadingFromCache(method, args);
            if (result.isPresent())
                return result.get();
        }

        if (method.isAnnotationPresent( Metric.class )) { //!< замеряем время начала
            before = System.nanoTime();
        }

        Object invoke = method.invoke( delegate, args );

        if (method.isAnnotationPresent( Metric.class )) { //!< замеряем время окончания и выводим результат
            after = System.nanoTime();
            System.out.println( "Метод " + method.getName() + " вызван. Время выполнения = " + (after - before) + " наносек." );
        }

        if (method.isAnnotationPresent( CacheMethod.class )) { //!< кешируем в нужную память, если метод помечен
            tryWritingCache(method, args, invoke);
        }

        return invoke;
    }


    private Optional<Object> tryReadingFromCache(Method method, Object[] args) {
        Object result = null;
        if (method.getAnnotation( CacheMethod.class ).savedPlace() == SAVED_PLACE.FILE) {
            System.out.println( "Попытка чтение в кеше (файл)" );
            String nameMethod = ".\\" + method.getName() + ".cache";
            Optional<Integer> res = cacheFile.get( nameMethod );
            result = res.isPresent() ? res.get() : null;

        } else if (method.getAnnotation( CacheMethod.class ).savedPlace() == SAVED_PLACE.MEMORY) {
            System.out.println( "Попытка чтение в кеше (память)" );
            result = cacheMemory.get( method, args );
        }
        return Optional.of( result );
    }

    private void tryWritingCache(Method method, Object[] args, Object invoke)  throws Throwable{
        if (method.getAnnotation( CacheMethod.class ).savedPlace() == SAVED_PLACE.FILE) {
            FileOutputStream fileOutputStream = new FileOutputStream( ".\\" + method.getName() + ".cache" );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );

            objectOutputStream.writeObject( invoke );

            objectOutputStream.close();
        } else if (method.getAnnotation( CacheMethod.class ).savedPlace() == SAVED_PLACE.MEMORY) {
            cacheMemory.add( method, args, invoke );
        }
    }
}
