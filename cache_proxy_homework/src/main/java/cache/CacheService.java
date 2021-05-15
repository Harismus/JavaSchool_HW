package cache;

import enums.cacheType;
import myannotation.CacheMethod;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Optional;

public class CacheService implements ICacheService {
    private CacheMemory cacheMemory = new CacheMemory();
    private CacheFile cacheFile;


    public CacheService (Path dirCache) {
        cacheFile = new CacheFile(dirCache);
    }

    @Override
    public Optional<Object> tryReadingFromCache(Method method, Object[] args) {
        Object result = null;
        if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.FILE) {
            System.out.println( "Попытка чтение в кеше (файл)" );

            Optional<Object> res = cacheFile.get( method.getName() );

            result = res.isPresent() ? res.get() : null;

        } else if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.MEMORY) {
            if (cacheMemory.contains( method, args)) {
                System.out.println( "Попытка чтение в кеше (память)" );
                Optional<Object> res = cacheMemory.get( method, args );
                result = res.isPresent() ? res.get() : null;
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
}
