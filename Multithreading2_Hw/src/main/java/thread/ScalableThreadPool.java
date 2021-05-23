package thread;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

public class ScalableThreadPool implements ThreadPool {

    int min;
    int max;
    volatile private Queue<Runnable> listTasks = new ArrayDeque<>();
    private List<ThreadHandler> listHandlers;

    ScalableThreadPool(int min, int max) {
        this.min = min;
        this.max = max;

        listHandlers = new ArrayList<>();

        for (int i = 0; i < min; i++) {
            listHandlers.add( new ThreadHandler( listTasks, false ) );
        }
    }

    @Override
    public void start() {
        for (int i = 0; i < listHandlers.size(); i++) {
            listHandlers.get( i ).start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (listTasks) {
            listTasks.offer( runnable ); //!< добавляем в конец очереди заданий
            listTasks.notify();

            if (listHandlers.size() == max)
                return;

            boolean b = false;
            for (Thread thread : listHandlers) {
                if (thread.getState() == Thread.State.RUNNABLE)
                    b = true;
            }

            if (b == false) {
                listHandlers.add( new ThreadHandler( listTasks, true ) );
            }
        }
    }
}
