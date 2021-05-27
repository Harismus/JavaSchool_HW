package thread;

import thread.Context;
import java.util.List;

public interface ExecutionManager {
    Context execute(Runnable callback, List<Runnable> tasks);
}
