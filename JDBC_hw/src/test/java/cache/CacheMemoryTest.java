package cache;

import calculator.Calculator;
import calculator.CalculatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static org.junit.Assert.*;

public class CacheMemoryTest {
    private CacheMemory cacheMemory = new CacheMemory();
    Calculator calculator = new CalculatorImpl();
    Method method;
    Object[] args;
    Object result;
    int factArg = 3;
    int expectedResult = 6;

    @Before
    public void init() {
        try {
            method = calculator.getClass().getMethod( "calcFactorial", int.class );
            args = new Object[]{factArg};
            result = method.invoke( calculator, args );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        cacheMemory.set( method.getName(), args, result );
    }

    @Test
    public void set() {

    }

    @Test
    public void get() {
        Optional<Data> res = cacheMemory.get( method.getName(), args );
        Data data = res.orElse( null );
        assertNotNull( data );

        assertEquals( expectedResult,  data.getInvoke() );
    }
}