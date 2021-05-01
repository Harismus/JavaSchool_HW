public interface IAuthorizer {
    boolean onLogin(String user, int password);
}
