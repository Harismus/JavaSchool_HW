package cache;

import java.lang.reflect.Method;
import java.util.*;

public class CacheMemory {
    class Data {
        Data(Method method, Object[] args) {
            this.method = method;
            this.args = args;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return Objects.equals( method, data.method ) && Arrays.equals( args, data.args );
        }

        @Override
        public int hashCode() {
            int result = Objects.hash( method );
            result = 31 * result + Arrays.hashCode( args );
            return result;
        }

        Method method;
        Object[] args;
    }

    private Map<Data, Object> cache = new HashMap<>();

    public void add(Method method, Object[] args, Object result)   {
        cache.put( new Data( method, args ), result );
    }

    public boolean contains(Method method, Object[] args) {
        return cache.containsKey(new Data( method, args ) );
    }

    public Optional<Object> get(Method method, Object[] args) {
        return Optional.of( cache.get(new Data( method, args )) );
    }

}
