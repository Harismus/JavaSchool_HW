
public class Registrator implements IRegistrator {

    IDataBase dataBase = new DataBase();

    @Override
    public boolean createLogin(String user, int password) {
        IWebPage webPage = new WebPage( user, password );
        if (!dataBase.hasElement( webPage.getID() )) {
            dataBase.newWebPage( webPage );
            return true;
        }

        return false;
    }
}
