import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegistratorTest {

    Registrator registrator = new Registrator();



    @Test
    public void createLogin() {
        assertTrue(registrator.createLogin( "Alex", 123 ));
//        assertTrue(registrator.createLogin( "Alex", 123 )); //!< проверка на две одинаковых странички

    }
}
