import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DataBaseMapTest {
    IDataBase dataBase = new DataBaseMap();
    IResource conference = new Conference();
    IResource auditorium = new Auditorium();
    IResource docAppointment = new DoctorsAppointment();
    Id idAuditorium;
    Id idConference;

    @Before
    public void init() {
        try {
            idConference = dataBase.add( conference );
            idAuditorium = dataBase.add( auditorium );
        } catch (ElementAvailableException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd() {
        Throwable thrown = assertThrows( ElementAvailableException.class, () -> {
            dataBase.add( conference );
        } );
        assertNotNull( thrown.getMessage() );
        System.out.println( "thrown = " + thrown.getMessage() );
    }

    @Test
    public void testRemove() {
        Throwable thrown = assertThrows( NoElementException.class, () -> {
            dataBase.remove( new Id() );
        } );
        assertNotNull( thrown.getMessage() );
        System.out.println( "thrown = " + thrown.getMessage() );
    }

    @Test
    public void testHadElement() {
        assertTrue(dataBase.hasElement( idConference ));
    }

    @After
    public void removeAddedItems() {
        try {
            dataBase.remove( idConference );
            dataBase.remove( idAuditorium );
        } catch (NoElementException e) {
            e.printStackTrace();
        }
    }
}