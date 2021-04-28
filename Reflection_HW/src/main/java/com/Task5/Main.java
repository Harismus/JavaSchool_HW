package com.Task5;


import java.lang.reflect.Proxy;


public class Main {


    public static void main(String[] args) {
        ServerImpl serverImpl = new ServerImpl();

        serverImpl.add( new Man( "Alex", 3 ) );
        serverImpl.add( new Man( "Ivan", 2 ) );
        serverImpl.add( new Woman( "Kate", 5 ) );
        serverImpl.add( new Woman( "Lizzie", 12 ) );
        serverImpl.add( new Man( "Vladimir", 1 ) );

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader serverClassLoader = serverImpl.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = serverImpl.getClass().getInterfaces();

        //Создаем прокси нашего объекта
        Server proxyServer = (Server) Proxy.newProxyInstance( serverClassLoader, interfaces, new ServerInvocationHandler( serverImpl ) );

        //Вызываем у прокси объекта один из методов нашего оригинального объекта
        proxyServer.get( 1 );
        proxyServer.get( 3 );
        proxyServer.get( 3 );
    }
}
