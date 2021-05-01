import java.util.List;
import java.util.Optional;

public interface IDataBase {
    boolean hasElement(Integer id);

    void newWebPage(IWebPage webPage);

    IWebPage getWebPage(String name, int password);

    List<IWebPage> getWebPages(String name);
}
