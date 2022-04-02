package dao;

import entities.News;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class NewsDao {
    public Long create(News e) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно создана " + e.toString());
        return e.getId();
    }

    public News selectByNewsId(Long newsId) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        String sql = "SELECT * FROM news u WHERE n.title = :title AND n.news_text = :news_text";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(News.class);
        query.setParameter("id", newsId);
        List<News> news = query.list();
        session.close();
        System.out.println("Найдено " + news.size() + " новостей");
        return news.get(0);


    }
}
