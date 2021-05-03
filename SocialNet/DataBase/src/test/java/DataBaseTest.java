import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataBaseTest {

    IDataBase dataBase = new DataBase();
    IWebPage alexWebpage;

    @Before
    public void newWebPage() {
        alexWebpage = new WebPage( "Alex", 123, 0 );
        dataBase.newWebPage( alexWebpage );
    }

    @Test
    public void hasElement() {
        assertTrue( dataBase.hasElement( alexWebpage.getID() ) );
    }

    @Test
    public void getWebPage() {
        String name = alexWebpage.getPersonalData().getData().getName();
        int password = alexWebpage.getPersonalData().getData().getPassword();

        IWebPage webPage =  dataBase.getWebPage( name, password );
        assertNotNull( webPage );
        assertEquals( name, webPage.getPersonalData().getData().getName() );
        assertEquals( password, webPage.getPersonalData().getData().getPassword() );
    }
}
