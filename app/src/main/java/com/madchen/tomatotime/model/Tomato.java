package com.madchen.tomatotime.model;

/**
 * Created by chenwei on 15/03/2017.
 */

public class Tomato {

    private long startTimeL;
    private long endTimeL;
    private int interrupt;

    public Tomato(long startTimeL, long endTimeL, int interrupt) {
        this.startTimeL = startTimeL;
        this.endTimeL = endTimeL;
        this.interrupt = interrupt;
    }

    public Tomato(long startTimeL, long endTimeL) {
        this(startTimeL, endTimeL, 0);
    }

    private long getStartTimeL() {
        return startTimeL;
    }

    private void setStartTimeL(long startTimeL) {
        this.startTimeL = startTimeL;
    }

    private long getEndTimeL() {
        return endTimeL;
    }

    private void setEndTimeL(long endTimeL) {
        this.endTimeL = endTimeL;
    }

    private int getInterrupt() {
        return interrupt;
    }

    private void setInterrupt(int interrupt) {
        this.interrupt = interrupt;
    }
}
