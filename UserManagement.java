public class UserManagement implements IUserManagement {

    private UserDao userDao;

    public UserManagement() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User getUserNames() {
        return userDao.getUsers();
    }

    @Override
    public void addUser(String userName) {
        userDao.insertUser(new User(userName));
    }


}
