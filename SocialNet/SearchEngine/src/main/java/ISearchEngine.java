import java.util.List;

public interface ISearchEngine {
    List<IWebPage> search(String name, int age);
    List<IWebPage> search(String name);
}
