package cache;

import calculator.Calculator;
import calculator.CalculatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.Assert.*;

public class CacheFileTest {

    private CacheFile cacheFile = new CacheFile( Paths.get("." + File.separatorChar ).toAbsolutePath());
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

        cacheFile.set( method.getName(), args, result );
    }

    @Test
    public void set() {
        File file = new File(Paths.get("." + File.separatorChar + method.getName() + ".cache").toAbsolutePath().toString());
        assertTrue( file.exists() );
    }

    @Test
    public void contains() {
    }

    @Test
    public void get() {
        Optional<Data> res = cacheFile.get( method.getName(), args );
        Data data = res.orElse( null );
        assertNotNull( data );

        assertEquals( expectedResult,  data.getInvoke() );
    }
}