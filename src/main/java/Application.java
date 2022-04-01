import dao.UserDao;
import entities.User;

import javax.persistence.Id;
import java.time.LocalDateTime;

public class Application {

    private static UserDao userDao = new UserDao();

    public static void main(String[] args) {
        User user = new User();
        user.setFirstname("Firstname2");
        user.setLastname("Lastname2");
        user.setCreatedAt(LocalDateTime.now());
        userDao.create(user);
        User existUser = userDao.selectFirstByUserId(1);
        System.out.println(existUser);

    }
}
