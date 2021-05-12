import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CacheMemory {
    class Data {
        Data(Method method, Object[] args) {
            this.method = method;
            this.args = args;
        }

        Method method;
        Object[] args;
    }

    private Map<Data, Object> cache = new HashMap<>();

    public void add(Method method, Object[] args, Object result) {
        cache.put( new Data( method, args ), result );
    }

    public Optional<Object> get(Method method, Object[] args) {
        return Optional.of( cache.get(new Data( method, args )) );
    }




}
