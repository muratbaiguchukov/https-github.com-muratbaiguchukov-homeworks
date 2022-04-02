package dao;

import entities.Category;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class CategoryDao {
    public Long create(Category e) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно создана " + e.toString());
        return e.getId();
    }

    public Category selectByCategoryId(Long newsId, Object categoryId) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        String sql = "SELECT * FROM category";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Category.class);
        query.setParameter("id", categoryId);
        List<Category> category = query.list();
        session.close();
        System.out.println("Найдено " + category.size() + " категорий");
        return category.get(0);


    }
}
