public class Authorizer implements IAuthorizer{
    @Override
    public boolean onLogin(String user, String password) {
       // IWebPage webPage = getWebPage(user, password);
        return true;
    }
}
