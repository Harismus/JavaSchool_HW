package calculator;

import java.lang.reflect.Proxy;
import java.nio.file.Path;

public class CacheProxy {
    private CalculatorImpl delegate;
    private Class[] interfaces;
    private ClassLoader serverClassLoader;
    private Path dirCache;

    public CacheProxy(Path dirCache) {
        this.dirCache = dirCache;
    }

    public Calculator cache(CalculatorImpl calculator) {
        this.delegate = calculator;

        //Получаем загрузчик класса у оригинального объекта
        serverClassLoader = delegate.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        interfaces = delegate.getClass().getInterfaces();

        //Создаем прокси нашего объекта
        return (Calculator) Proxy.newProxyInstance( serverClassLoader, interfaces, new CalculatorCacheInvocationHandler( delegate, dirCache ) );
    }
}
