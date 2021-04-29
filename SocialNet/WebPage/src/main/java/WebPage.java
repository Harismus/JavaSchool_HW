public class WebPage implements IWebPage{

    private IWall wall = new Wall();
    private IPersonalData personalData;
    private IFunctionPanel functionPanel = new FunctionPanel();
    private IButton buttonFunctions = new ButtonPanel(functionPanel);
    private IButton buttonPost = new ButtonPost(wall);
    static private int ID = 0;

    WebPage(String name, int age) {
        ID++;

        personalData = new PersonalData(name, age);
    }

    @Override
    public Integer getID() {
        return 0;
    }

    @Override
    public IPersonalData getPersonalData() {
        return personalData;
    }
}
