public class Conference implements IResource {
    private int number;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Conference guest = (Conference) obj;
        return number == guest.number;
    }
}
