
import java.util.HashMap;
import java.util.Map;

public class DataBase implements IDataBase {

    private Map<Integer, IWebPage> base = new HashMap<>();


    @Override
    public boolean hasElement(Integer id) {
        return base.containsKey( id );
    }

    @Override
    public void newWebPage(IWebPage webPage) {
        base.put( webPage.getID(), webPage );
    }

    @Override
    public IWebPage getWebPage(String name, int password) {

        for (Map.Entry<Integer, IWebPage> entry : base.entrySet()) {
            IPersonalData personalData = entry.getValue().getPersonalData();
            String nameElement = personalData.getData().getName();
            int passwordElement = personalData.getData().getAge();

            if (nameElement.equals( name ) && (passwordElement == password)) {
                return entry.getValue();
            }
        }

        return null;
    }
}
