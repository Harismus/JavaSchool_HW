import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistratorTest {

    Registrator registrator = new Registrator(new DataBase());

    @Test
    public void createLogin() {
        assertTrue(registrator.createWebPage( "Alex", 123 ));
        assertFalse(registrator.createWebPage( "Alex", 123 )); //!< проверка на две одинаковых странички

    }
}
