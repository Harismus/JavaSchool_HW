public class Id {
    private static long ID = 0;
    private long currentID = 0;

    Id() {
        currentID = ID++;
    }

    public long getCurrentID() {
        return currentID;
    }
}
