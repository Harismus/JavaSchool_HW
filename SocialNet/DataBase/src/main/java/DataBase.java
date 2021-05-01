
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @DataBase реализовывает интерфейс IDataBase с базой в виде Map
 */
public class DataBase implements IDataBase {

    private static Map<Integer, IWebPage> base = new HashMap<>();

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
            int passwordElement = personalData.getData().getPassword();

            if (nameElement.equals( name ) && (passwordElement == password)) {
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public List<IWebPage> getWebPages(String name) {
        List<IWebPage> listWebPages = new ArrayList<>();

        for (Map.Entry<Integer, IWebPage> e : base.entrySet()) {
            IWebPage page = e.getValue();
            IPersonalData personalData = page.getPersonalData();
            Data data =  personalData.getData();
            if (data.getName().equals( name ))
                listWebPages.add( page );
        }

        return listWebPages;
    }
}