package thread;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

public class FixedThreadPoolImpl implements ThreadPool {
    volatile private Queue<Runnable> listTasks = new ArrayDeque<>();
    private List<ThreadHandler> threadHandler = new ArrayList<>();

    public FixedThreadPoolImpl(int countThread) {
        if (countThread <= 0)
            throw new IllegalArgumentException( "Не правильный аргумент" );
        for (int i = 0; i < countThread; i++) {
            threadHandler.add( new ThreadHandler( listTasks, true ) );
        }
    }

    @Override
    public void start() {
        for (int i = 0; i < threadHandler.size(); i++) {
            threadHandler.get( i ).start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (listTasks) {
            listTasks.offer( runnable ); //!< добавляем в конец очереди заданий
            listTasks.notify();
        }
    }

    @Override
    public List<ThreadHandler> getThreads() {
        return threadHandler;
    }
}
