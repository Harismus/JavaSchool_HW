package thread;

import java.util.List;

public interface ExecutionManager {
    Context execute(Runnable callback, List<Runnable> tasks);
}
