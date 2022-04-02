package service;

import dao.CategoryDao;
import entities.Category;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class CategoryService {

    CategoryDao categoryDao = new CategoryDao();

    public Long create(Category category) {

        return categoryDao.create(category);
    }

    public static void update(Category e) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        Category em = (Category) session.load(Category.class, e.getId());
        em.setName(e.getName());
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно изменена " + e.toString());
    }

    public static List<Category> read() {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        List<Category> category = session.createQuery("FROM Category").list();
        session.close();
        System.out.println("Найдено " + category.size() + " категорий");
        return category;
    }
}
