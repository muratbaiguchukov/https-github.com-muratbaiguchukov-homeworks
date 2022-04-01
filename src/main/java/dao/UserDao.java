package dao;

import entities.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class UserDao {

    public Integer create(User e) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно создан " + e.toString());
        return e.getId();
    }

    public User selectFirstByUserId(Integer userId) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        String sql = "SELECT * FROM users u WHERE u.id = :id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(User.class);
        query.setParameter("id", userId);
        List<User> users = query.list();
        session.close();
        System.out.println("Найдено " + users.size() + " пользователей");
        return users.get(0);


    }
}
