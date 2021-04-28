public class Authorizer implements IAuthorizer{
    @Override
    public boolean onLogin(String user, String password) {
        return true;
    }
}
