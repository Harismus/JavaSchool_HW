package cache;

import enums.cacheType;
import myannotation.CacheMethod;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.Optional;

public class CacheService implements ICacheService {
    private CacheMemory cacheMemory = new CacheMemory();
    private CacheFile cacheFile = new CacheFile();

    @Override
    public Optional<Object> tryReadingFromCache(Method method, Object[] args) {
        Object result = null;
        if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.FILE) {
            System.out.println( "Попытка чтение в кеше (файл)" );
            String nameMethod = ".\\" + method.getName() + ".cache";
            Optional<Integer> res = cacheFile.get( nameMethod );
            result = res.isPresent() ? res.get() : null;

        } else if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.MEMORY) {
            if (cacheMemory.contains( method, args )) {
                System.out.println( "Попытка чтение в кеше (память)" );
                Optional<Object> res = cacheMemory.get( method, args );
                result = res.isPresent() ? res.get() : null;
            }
        }
        return Optional.ofNullable ( result );
    }

    @Override
    public void tryWritingCache(Method method, Object[] args, Object invoke) throws Throwable {
        if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.FILE) {
            System.out.println( "Запись кеша в файл" );

            FileOutputStream fileOutputStream = new FileOutputStream( ".\\" + method.getName() + ".cache" );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );

            objectOutputStream.writeObject( invoke );

            objectOutputStream.close();
        } else if (method.getAnnotation( CacheMethod.class ).savedPlace() == cacheType.MEMORY) {
            System.out.println( "Запись кеша в память" );
            cacheMemory.add( method, args, invoke );
        }
    }
}
