package cache;

import java.lang.reflect.Method;
import java.util.Optional;


public interface ICachePlace {

    /**
     *
     * @param methodName
     * @param args
     * @param result
     */
    void set(String methodName, Object[] args, Object result);


    /**
     *
     * @param method
     * @return
     */
    Optional<Data> get(String method, Object[] args);
}
