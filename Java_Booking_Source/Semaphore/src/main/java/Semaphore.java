import java.time.Duration;
import java.util.Date;

public class Semaphore implements ISemaphore {

    IDataBase dataBase;



    @Override
    public Id Acquire(User user, IResource resource, Date start, Duration duration) {
        return null;
    }

    @Override
    public boolean Release(Id id) {
        return false;
    }
}
