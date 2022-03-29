import entities.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


public class Aplication {
    public static void main(String[] args) {
    }

    public static Integer create(Employee e) { // создание метода create -- добавить нового сотрудника
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно создан " + e.toString());
        return e.getId();
    }

    public static List<Employee> read() { // Читать из таблицы (read)
        Session session = HibernateUtil.buildSessionFactory().openSession();
        List<Employee> employees = session.createQuery("FROM Employee").list();
        session.close();
        System.out.println("Найдено " + employees.size() + " сотрудников");
        return employees;
    }

    public static void update(Employee e) { // изменить запись (update)
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        Employee em = (Employee) session.load(Employee.class, e.getId());
        em.setName(e.getName());
        em.setAge(e.getAge());
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно изменено " + e.toString());
    }

    public static void delete(Integer id) { // удаление по id
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee e = findById(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно удалено " + e.toString());
    }

    public static Employee findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee e = (Employee) session.load(Employee.class, id);
        session.close();
        return e;
}
}
