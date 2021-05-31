package thread;

import java.util.Queue;

public class ThreadHandler extends Thread {
    private Queue<Runnable> listTasks;
    private Runnable currentRunnable;
    private boolean isRemovable;
    private boolean wasThrowned = false;

    ThreadHandler(Queue<Runnable> listTasks, boolean isRemovable) {
        this.isRemovable = isRemovable;
        this.listTasks = listTasks;
    }

    boolean getWasThrowned() {
        return wasThrowned;
    }

    @Override
    public void run() {
        System.out.println( "Thread.currentThread().getName() = " + Thread.currentThread().getName() +
                "  isRemovable = " + isRemovable );

        while (!Thread.currentThread().isInterrupted()) {

            synchronized (listTasks) {
                if (listTasks.isEmpty()) {
                    try {
                        System.out.println( "isRemovable = " + isRemovable );
                        if (isRemovable) {
                            System.out.println( "exit from thread + " + Thread.currentThread().getName() );
                            return;
                        } else {
                            System.out.println( "Thread wait" );
                            listTasks.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                currentRunnable = listTasks.poll();
            }

            if (!currentRunnable.equals( null )) {
                System.out.println( "Thread.currentThread().getName() start = " + Thread.currentThread().getName() );
                try {
                    currentRunnable.run();
                } catch (ArithmeticException e) {
                    wasThrowned = true;
                }
            }
        }
    }


}