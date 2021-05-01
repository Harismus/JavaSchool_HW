
public class Registrator implements IRegistrator {

    IDataBase dataBase = new DataBase();
    static int ID = 0;

    Registrator(IDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean createWebPage(String user, int password) {
        IWebPage webPage = new WebPage( user, password, ID );
        if (!dataBase.hasElement( webPage.getID() )) {
            dataBase.newWebPage( webPage );
            ++ID;
            return true;
        }

        return false;
    }
}
