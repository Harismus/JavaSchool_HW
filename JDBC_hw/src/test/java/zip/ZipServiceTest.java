package zip;

import cache.CacheFile;
import calculator.Calculator;
import calculator.CalculatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Paths;


public class ZipServiceTest {
    private CacheFile cacheFile = new CacheFile( Paths.get( "." + File.separatorChar ).toAbsolutePath() );
    Calculator calculator = new CalculatorImpl();
    ZipService zipService = new ZipService( Paths.get( "." + File.separatorChar ).toAbsolutePath() );
    Method method;

    @Before
    public void init() {
        try {
            method = calculator.getClass().getMethod( "circleArea", String.class, double.class, double.class );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void zip() {
        zipService.zip( method.getName() + ".cache", method.getName() + ".zip" );
    }
}