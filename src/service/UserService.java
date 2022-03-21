package service;

import dao.UserDao;
import model.User;

public class UserService {

   public int registerUser(User user) {
       UserDao userDao = new UserDao();
       return userDao.insertUser(user);

   }

    public String authorize(String login, String password){
           return null;
    }

    public int authorize(User newUser1) {
        return 0;
    }
}
