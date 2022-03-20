package service;

import dao.UserDao;
import model.User;

public class UserService {

   public int registerUser(User user) {
       UserDao userDao = new UserDao();
       return userDao.insertUser(user);

   }

    public void authorize(String login, String password){

    }
}
