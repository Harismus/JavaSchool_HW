public class WebPage implements IWebPage{

    private IWall wall = new Wall();
    private IPersonalData personalData = new PersonalData();
    private IFunctionPanel functionPanel = new FunctionPanel();
    private IButton buttonFunctions = new ButtonPanel(functionPanel);
    private IButton buttonPost = new ButtonPost(wall);

    WebPage() {

    }

    @Override
    public Object getGui() {
        return null;
    }
}
