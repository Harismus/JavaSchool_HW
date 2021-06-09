package model;

public class Id {
    private static long ID = 0;
    private long currentID = 0;

    public Id() {
        currentID = ID++;
    }

    public long getCurrentID() {
        return currentID;
    }
}
