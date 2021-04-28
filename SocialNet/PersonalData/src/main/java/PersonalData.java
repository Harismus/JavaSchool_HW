import java.util.Collection;

public class PersonalData implements IPersonalData {
    private Data data;

    PersonalData() {
        data = new Data( "default", 0 );
    }

    @Override
    public Data getData() {
        return null;
    }

    @Override
    public void saveData(String name, int age) {
        data = new Data( name, age );
    }
}
