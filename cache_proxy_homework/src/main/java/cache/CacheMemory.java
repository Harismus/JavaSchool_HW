package cache;

import java.lang.reflect.Method;
import java.util.*;


public class CacheMemory implements ICachePlace {


    private Set<Data> list = new HashSet<>();

    @Override
    public void set(String methodName, Object[] args, Object result) {
        list.add( new Data( methodName, args, result ) );
    }


    @Override
    public Optional<Data> get(String methodName, Object[] args) {
        Data res = null;
        for (Data d : list) {
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
