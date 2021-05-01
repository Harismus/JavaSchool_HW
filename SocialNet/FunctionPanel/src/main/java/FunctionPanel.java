
public class FunctionPanel implements IFunctionPanel {
    private IMessenger messager = new Messenger();
    private ISearchEngine searchEngine = new SearchEngine(new DataBase());
    private boolean isHide = true;

    @Override
    public Object getGui() {
        return null;
    }

    @Override
    public void show() {
        isHide = false;
    }

    @Override
    public void hide() {
        isHide = true;
    }

    @Override
    public boolean isHide() {
        return isHide;
    }


}
