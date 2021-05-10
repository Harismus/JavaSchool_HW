import org.junit.Test;

import java.lang.reflect.Proxy;

public class CalculatorInvocationHandlerTest {

    @Test
    public void invoke() {
//        Calculator delegate = new CalculatorImpl();
//
//        //Получаем загрузчик класса у оригинального объекта
//        ClassLoader serverClassLoader = delegate.getClass().getClassLoader();
//
//        //Получаем все интерфейсы, которые реализует оригинальный объект
//        Class[] interfaces = delegate.getClass().getInterfaces();
//
//        //Создаем прокси нашего объекта
//        Calculator proxyCalculator = (Calculator) Proxy.newProxyInstance( serverClassLoader, interfaces, new CalculatorInvocationHandler( delegate ) );
//
//        System.out.println( "proxyCalculator = " + proxyCalculator.calc(15 ));

        Calculator  calculator =  new PerformanceProxy(new CalculatorImpl());
        System.out.println(calculator.calc(3));

    }
}