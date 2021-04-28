public interface IAuthorizer {
    boolean onLogin(String user, String password);
}
