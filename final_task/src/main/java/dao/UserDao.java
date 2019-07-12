package dao;

public interface UserDao {
    void signIn(String name, String password,String telephone);

    void registration(String name, String passwprd);
}
