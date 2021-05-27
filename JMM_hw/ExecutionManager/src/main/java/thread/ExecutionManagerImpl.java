package thread;

import thread.Context;
import thread.ExecutionManager;
import java.util.List;

public class ExecutionManagerImpl implements ExecutionManager {

    ThreadPool threadPool;
    Context context ;

    @Override
    public Context execute(Runnable callback, List<Runnable> tasks) {
        threadPool = new FixedThreadPoolImpl( tasks.size() );
        context = new ContextImpl(tasks);

        for (int i = 0; i < tasks.size(); i++) {
            threadPool.execute( tasks.get( i ) );
        }

        threadPool.start();

        return null;
    }
}
