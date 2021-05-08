import java.time.Duration;
import java.util.Date;

public interface ISemaphore {
    Id Acquire(User user, IResource resource, Date start, Duration duration) throws ResourceIsBusy;
    boolean Release(Id id);

}
