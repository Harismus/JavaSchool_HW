public class DoctorsAppointment implements IResource {
    private String doctorsName;
    private int numberOffice;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        DoctorsAppointment guest = (DoctorsAppointment) obj;
        return doctorsName.equals( guest.doctorsName ) && numberOffice == guest.numberOffice;
    }
}
