import com.Task1.Calculator;
import com.Task1.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task1Test {

    @Test
    public void calc() {

        Calculator calculator = new CalculatorImpl();

        assertEquals(calculator.calc( 3 ), 6);

    }

}
