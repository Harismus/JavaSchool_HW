import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

public class RegistratorTest {

    IDataBase dataBase = Mockito.mock( IDataBase.class );
    Registrator registrator = new Registrator(dataBase);

    @Test
    public void createLogin() {

        Mockito.when(dataBase.hasElement(anyInt())).thenReturn(false).thenReturn( true );

        assertTrue(registrator.createWebPage( "Alex", 123 ));
        assertFalse(registrator.createWebPage( "Alex", 123 )); //!< проверка на две одинаковых странички
    }
}
