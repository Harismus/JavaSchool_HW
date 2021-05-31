package thread;

import java.lang.Thread;
import java.lang.Thread.State;
import java.util.List;

public class ContextImpl implements Context {
    private List<ThreadHandler> tasks;

    ContextImpl(List<ThreadHandler> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getCompletedTaskCount() {
        return (int)tasks.stream()
                .filter( t -> {
                    return t.getState() == State.TERMINATED && !t.getWasThrowned();
        } ).count();
    }

    @Override
    public int getFailedTaskCount() {
        return (int) tasks.stream().filter( t -> t.getWasThrowned() ).count();
    }

    @Override
    public int getInterruptedTaskCount() {
        return (int) tasks.stream().filter( t -> t.isInterrupted() ).count();
    }

    @Override
    public void interrupt() {
        tasks.stream().forEach( t -> t.interrupt() );
    }

    @Override
    public boolean isFinished() {
        if ((getCompletedTaskCount() == tasks.size()) || (getInterruptedTaskCount() == tasks.size())) {
            return true;
        }

        return false;
    }
}
