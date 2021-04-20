package com.company;

import java.util.TimerTask;

public class WrapTimerTask {
    public static TimerTask wrap(Runnable r) {
        return new TimerTask() {

            @Override
            public void run() {
                r.run();
            }
        };
    }
}
