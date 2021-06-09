import model.Auditorium;
import model.Conference;
import model.DoctorsAppointment;
import model.IResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DataBaseMapTest {
    service.IDataBase dataBase = new service.DataBaseMap();
    IResource conference = new Conference();
    IResource auditorium = new Auditorium();
    IResource docAppointment = new DoctorsAppointment();
    model.Id idAuditorium;
    model.Id idConference;

    @Before
    public void init() {
        try {
            idConference = dataBase.add( conference );
            idAuditorium = dataBase.add( auditorium );
        } catch (exceptions.ElementAvailableException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd() {
        Throwable thrown = assertThrows( exceptions.ElementAvailableException.class, () -> {
            dataBase.add( conference );
        } );
        assertNotNull( thrown.getMessage() );
        System.out.println( "thrown = " + thrown.getMessage() );
    }

    @Test
    public void testRemove() {
        Throwable thrown = assertThrows( exceptions.NoElementException.class, () -> {
            dataBase.remove( new model.Id() );
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
        } catch (exceptions.NoElementException e) {
            e.printStackTrace();
        }
    }
}