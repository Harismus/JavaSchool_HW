public class Authorizer implements IAuthorizer{

    IDataBase dataBase;

    Authorizer(IDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean onLogin(String user, int password) {
        IWebPage webPage = dataBase.getWebPage(user, password);
        return webPage != null ? true : false;
    }
}
