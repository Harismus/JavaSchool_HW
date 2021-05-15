package cache;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.lang.reflect.Method;
import java.util.*;

public class CacheMemory implements ICachePlace{

    private Map<Data, Object> cache = new HashMap<>();

    @Override
    public void set(String methodName, Object[] args, Object result)   {
        cache.put( new Data( methodName, args ), result );
    }

    @Override
    public boolean contains(Method method, Object[] args) {
        return cache.containsKey(new Data( method.getName(), args ) );
    }

    @Override
    public Optional<Object> get(Method method, Object[] args) {
        return Optional.of( cache.get(new Data( method.getName(), args )) );
    }

    @Override
    public Optional<Object> get(String method) { //!< тут не используется
        return Optional.empty();
    }

}
