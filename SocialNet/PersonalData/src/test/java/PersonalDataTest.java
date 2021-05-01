import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonalDataTest {

    IPersonalData personalData;

    @Before
    public void init() {
        String name = "Alex";
        int password = 123;
        personalData = new PersonalData( name, password );
    }

    @Test
    public void getData() {
        assertEquals("Alex", personalData.getData().getName());
    }

    @Test
    public void setData() {
        String name = "Alex2";
        int password = 123;

        personalData.saveData( name, password );

        assertEquals(name, personalData.getData().getName());
    }

}
