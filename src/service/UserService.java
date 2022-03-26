package service;

import dao.UserDao;
import dao.UserLodDao;
import enams.Success;
import model.User;
import model.UserLog;

public class UserService {
    private UserDao userDao = new UserDao();

    public int registerUser(User user) {
        return userDao.insertUser(user);

    }

    public void authorize(String login, String password) {
        User exist = userDao.selectUserByLogin(login);
        if (exist != null) {
            UserLodDao userLodDao = new UserLodDao(); // логирование
            UserLog userLog = new UserLog();
            userLog.setUser(exist);
            userLog.setId(1);
            userLog.setSuccess(Success.OK);
            userLodDao.insertUserLog(userLog);
            userLog.setId(1);
            if (exist.getPassword().equals(password)) {
                System.out.println("success");
                userLog.setSuccess(Success.OK);
                userLodDao.insertUserLog(userLog);

            } else {
                userLog.setSuccess(Success.FAIL);
                userLodDao.insertUserLog(userLog);
                System.out.println("ref fail");
            }
        }
    }
}
