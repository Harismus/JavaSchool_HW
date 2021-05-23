package thread;

import java.util.ArrayDeque;
import java.util.Queue;

public class ThreadPoolImpl implements ThreadPool {

    volatile private Queue<Runnable> listTasks = new ArrayDeque<>();
    private ThreadHandler[] threadHandler;

    public ThreadPoolImpl(int countThread) {
        if (countThread <= 0)
            throw new IllegalArgumentException( "Не правильный аргумент" );

        threadHandler = new ThreadHandler[countThread];

        for (int i = 0; i < countThread; i++) {
            threadHandler[i] = new ThreadHandler(listTasks);
        }
    }

    @Override
    public void start() {
        for (int i = 0; i < threadHandler.length; i++) {
            threadHandler[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (listTasks) {
            listTasks.offer( runnable ); //!< добавляем в конец очереди заданий
            listTasks.notify();
        }
    }
}
