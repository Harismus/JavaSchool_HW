public class WebPage implements IWebPage{

    private IWall wall = new Wall();
    private IPersonalData personalData;
    private IButton buttonPost = new ButtonPost(wall);
    private int ID = 0;

    WebPage(String name, int age,  int password, int ID) {
        ID++;

        personalData = new PersonalData(name, age, password);
    }

    WebPage(String name, int password, int ID) {
        ID++;

        personalData = new PersonalData(name, password);
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public IPersonalData getPersonalData() {
        return personalData;
    }
}
