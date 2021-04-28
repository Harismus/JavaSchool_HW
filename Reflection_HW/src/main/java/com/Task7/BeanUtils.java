package com.Task7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Class ClassTo = to.getClass();
        Class ClassFrom = from.getClass();

        Method[] publicMethodsTo = ClassTo.getDeclaredMethods();
        Method[] publicMethodsFrom = ClassFrom.getDeclaredMethods();

        for (Method methodFrom : publicMethodsTo) {
            if (methodFrom.getName().startsWith( "get" )) {
                for (Method methodTo : publicMethodsFrom) {
                    if (methodTo.getName().startsWith( "set" )) {

                        if ((methodTo.getParameterTypes()[0].isAssignableFrom( methodFrom.getReturnType())
                                || methodFrom.getReturnType().getSuperclass() == methodTo.getParameterTypes()[0])
                                && methodFrom.getName().substring( 3 ).equals( methodTo.getName().substring( 3 ) )) {
                            try {
                                methodTo.invoke( to, methodFrom.invoke( from ) );
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    }
}
