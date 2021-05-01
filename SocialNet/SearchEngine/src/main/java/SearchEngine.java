import java.util.ArrayList;
import java.util.List;

public class SearchEngine implements ISearchEngine {

    IDataBase dataBase;

    SearchEngine(IDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<IWebPage> search(String name, int age) {
        List<IWebPage> webPages = dataBase.getWebPages( name );
        return webPages;
    }

    @Override
    public List<IWebPage> search(String name) {
        List<IWebPage> webPages = dataBase.getWebPages( name );
        return webPages;
    }
}
