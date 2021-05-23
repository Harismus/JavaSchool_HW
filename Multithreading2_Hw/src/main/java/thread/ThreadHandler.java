package thread;

import java.util.Queue;

public class ThreadHandler extends Thread {
    private Queue<Runnable> listTasks;



    private Runnable currentRunnable;
    ThreadHandler(Queue<Runnable> listTasks) {
        System.out.println( "ThreadHandler.ThreadHandler" );
        this.listTasks = listTasks;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println( "Thread.currentThread().getName() = " + Thread.currentThread().getName() );
            synchronized (listTasks) {
                if (listTasks.isEmpty()) {
                    try {
                        System.out.println("Thread wait");
                        listTasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                System.out.println( "Thread.currentThread().getName() start = " + Thread.currentThread().getName() );
                currentRunnable = listTasks.poll();

            }

            if (!currentRunnable.equals( null )) {
                currentRunnable.run();
            }

        }
    }
}
