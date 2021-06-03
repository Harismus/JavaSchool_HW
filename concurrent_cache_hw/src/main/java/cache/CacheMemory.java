package cache;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class CacheMemory implements ICachePlace {

    Object object = new Object();
    private ConcurrentHashMap<Data, Object> list = new ConcurrentHashMap();

    @Override
    public void set(String methodName, Object[] args, Object result) {
        list.put( new Data( methodName, args, result ), object );
    }

    @Override
    public Optional<Data> get(String methodName, Object[] args) { //!< TODO переписать нормально нужно
        Data res = null;
        for (Data d : list.keySet()) {
            boolean b = false;

            if (d.getMethodName().equals( methodName )) {
                for (Object dataArg : d.getArgs()) {

                    for (Object arg : args) {
                        if (dataArg == arg) {
                            b = true;
                            break;
                        }
                    }
                    if (b == false) {
                        break;
                    }

                }
                res = d;
                break;
            }
        }


        return Optional.ofNullable( res );
    }

}
