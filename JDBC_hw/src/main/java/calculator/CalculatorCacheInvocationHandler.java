package calculator;

import cache.*;
import myannotation.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Optional;


public class CalculatorCacheInvocationHandler implements InvocationHandler {
    private Object delegate;
    long before = 0;
    long after = 0;

    ICacheService cacheService;

    public CalculatorCacheInvocationHandler(Object delegate, Path dirCache) {
        this.delegate = delegate;
        cacheService = new CacheService(dirCache);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent( CacheMethod.class )) { //!< если кеш аннотация, то проверим наличия в кеше результата
            Optional<Object> result = cacheService.tryReadingFromCache( method, args);
            if (result.isPresent())
                return  result.get();
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
            cacheService.tryWritingCache( method, args, invoke );
        }

        return invoke;
    }
}
