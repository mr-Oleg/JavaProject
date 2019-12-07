package casino.services.interfaces;

public interface SecurityService {
    String findLoggedInLogin();

    void autoLogin(String login, String password);
}
