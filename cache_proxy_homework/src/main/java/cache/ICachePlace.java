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


  //  void set(String pathToFile, String methodName, Object[] args, Object result);

    /**
     *
     * @param method
     * @param args
     * @return
     */
    Optional<Object> get(Method method, Object[] args);

    /**
     *
     * @param method
     * @return
     */
    Optional<Object> get(String method);

    /**
     *
     * @param method
     * @param args
     * @return
     */
    boolean contains(Method method, Object[] args);
}
