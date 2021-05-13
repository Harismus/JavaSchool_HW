package cache;

import calculator.*;
import java.lang.reflect.Proxy;

public class CacheProxy {
    private CalculatorImpl delegate;
    private Class[] interfaces;

    public CacheProxy() {
    }
    
    public Calculator cache(CalculatorImpl calculator) {
        this.delegate = calculator;

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader serverClassLoader = delegate.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        interfaces = delegate.getClass().getInterfaces();

        //Создаем прокси нашего объекта
        return (Calculator) Proxy.newProxyInstance( serverClassLoader, interfaces, new CalculatorCacheInvocationHandler( delegate ) );
    }
}
