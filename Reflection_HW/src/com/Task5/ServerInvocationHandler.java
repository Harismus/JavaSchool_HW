package com.Task5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServerInvocationHandler implements InvocationHandler {
    private ServerImpl serverImpl;
    private Person cachePerson;

    public ServerInvocationHandler(ServerImpl serverImpl) {
        this.serverImpl = serverImpl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (args.length == 1 && cachePerson == null) {
            cachePerson = (Person) method.invoke( serverImpl,  args );
            System.out.println( "Read from server cachePerson = null" );
        } else if (args.length == 1 && cachePerson != null && cachePerson.getId() != (int) args[0]) {
            cachePerson = (Person) method.invoke( serverImpl,  args );
            System.out.println( "Read from server  cachePerson.getId() != (int) args[0]" );
        } else {
            System.out.println( "Read from cache" );
        }

        return cachePerson;
    }
}
