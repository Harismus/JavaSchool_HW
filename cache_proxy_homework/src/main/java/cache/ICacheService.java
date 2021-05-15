package cache;

import java.lang.reflect.Method;
import java.util.Optional;

public interface ICacheService {

    /**
     * Производится попытка чтения данных из кеша
     * @param method
     * @param args
     * @return
     */
    Optional<Object> tryReadingFromCache(Method method, Object[] args);

    /**
     * Производится попытка записи в кеш
     * @param method
     * @param args
     * @param invoke
     * @throws Throwable
     */
    void tryWritingCache(Method method, Object[] args, Object invoke);
}
