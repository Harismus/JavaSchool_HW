import calculator.Calculator;
import calculator.CalculatorCacheInvocationHandler;
import calculator.CalculatorImpl;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Proxy;
import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CalculatorCacheInvocationHandlerTest {

    Calculator delegate = new CalculatorImpl();

    //Получаем загрузчик класса у оригинального объекта
    ClassLoader serverClassLoader = delegate.getClass().getClassLoader();

    //Получаем все интерфейсы, которые реализует оригинальный объект
    Class[] interfaces = delegate.getClass().getInterfaces();

    //Создаем прокси нашего объекта
    Calculator proxyCalculator = (Calculator) Proxy.newProxyInstance( serverClassLoader, interfaces, new CalculatorCacheInvocationHandler( delegate, Paths.get("." + File.separatorChar ).toAbsolutePath() ) );

    public  <T> Optional<T> readCache(String nameMethod) {
        FileInputStream fileInputStream = null;
        T cache = null;
        try {
            fileInputStream = new FileInputStream(nameMethod) ;
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            cache = (T) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.of(cache);
    }

    @Test
    public void calcFactorial() {
        Integer res =  proxyCalculator.calcFactorial(3 );
        System.out.println( "calcFactorial result = " + res);

        res =  proxyCalculator.calcFactorial(3 );
        System.out.println( "calcFactorial result = " + res);


        assertEquals((Integer) 6, res);


//
//        try {
//            String nameMethod = ".\\" + Calculator.class.getMethod( "calcFactorial", int.class ).getName() + ".cache";
//            Optional<Integer> cache = readCache(nameMethod);
//
//            int cacheInteger = cache.get();
//            System.out.println( " cacheInteger  = " +  cacheInteger  );
//
//            assertEquals( res, cacheInteger );
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }
}