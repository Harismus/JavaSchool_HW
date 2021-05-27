package thread;

import java.util.List;

public class ContextImpl implements Context {
    private List<Runnable> tasks;

    ContextImpl(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getCompletedTaskCount() {
        return 0;
    }

    @Override
    public int getFailedTaskCount() {
        return 0;
    }

    @Override
    public int getInterruptedTaskCount() {
        return 0;
    }

    @Override
    public void interrupt() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
