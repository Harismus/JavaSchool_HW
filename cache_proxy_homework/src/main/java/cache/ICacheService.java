package cache;

import java.lang.reflect.Method;
import java.util.Optional;

public interface ICacheService {

    Optional<Object> tryReadingFromCache(Method method, Object[] args);

    void tryWritingCache(Method method, Object[] args, Object invoke) throws Throwable;
}
