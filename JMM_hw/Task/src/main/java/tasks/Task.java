package tasks;

import Exceptions.InvalidArgument;

import java.util.concurrent.*;

public class Task<T> {

    private ExecutorService service = Executors.newSingleThreadExecutor();
    private Future<? extends T> future;
    private T result = null;
    private boolean isThrew = false;


    public Task(Callable<? extends T> callable) {
        future = service.submit( callable );
    }

    public T get() throws ExecutionException, InterruptedException {
        if (isThrew) {
            throw new InvalidArgument();
        }

        if (service.isShutdown()) {
            return result;
        }

        try {
            result = future.get();
        }
        catch (InterruptedException  | ExecutionException e) {
            exceptionHandler(e.getMessage());
        }

        service.shutdown();
        return result;
    }

    void exceptionHandler(String message) {
        System.out.println( "message = " + message );
        isThrew = true;
        service.shutdown();
        throw new InvalidArgument();
    }
}

