import java.time.Duration;
import java.util.Date;

public class Semaphore implements ISemaphore {

    IDataBase dataBase = new DataBaseMap();

    @Override
    public Id Acquire(User user, IResource resource, Date start, Duration duration) throws  ResourceIsBusy {
        try {
            return dataBase.add( resource );
        } catch (ElementAvailableException e) {
            throw new ResourceIsBusy( "Данный ресурс занят, попробуйте позже" );
        }
    }

    @Override
    public boolean Release(Id id) {
        try {
            dataBase.remove( id );
            return true;
        } catch (NoElementException e) {
            return false;
        }
    }
}
