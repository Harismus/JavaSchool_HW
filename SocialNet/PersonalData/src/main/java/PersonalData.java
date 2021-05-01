import java.util.Collection;

public class PersonalData implements IPersonalData {
    private Data data;

    PersonalData(String name, int age, int password) {
        data = new Data( name, age, password );
    }

    PersonalData(String name, int password) {
        data = new Data( name, password );
    }

    @Override
    public Data getData() {
        return data;
    }

    @Override
    public void saveData(String name, int password) {
        data = new Data( name, password );
    }
}
