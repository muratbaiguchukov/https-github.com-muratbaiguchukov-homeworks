package service;

import dao.NewsDao;
import entities.News;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
public class NewsService {

    NewsDao newsDa0 = new NewsDao();

    public Long create(News news, Object e) {

        return newsDa0.create(news);

    }

    public static List<News> read() {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        List<News> news = session.createQuery("FROM News").list();
        session.close();
        System.out.println("Найдено " + news.size() + " новостей");
        return news;
    }

    public static News findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        News e = (News) session.load(News.class, id);
        session.close();
        return e;
    }

    public static void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        News e = findById(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно удалена " + e.toString());
    }


    public static void update(News e) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        session.beginTransaction();
        News em = (News) session.load(News.class, e.getId());
        em.setNewsText(e.getNewsText());
        em.setTitle(e.getTitle());
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно изменено " + e.toString());
    }

    public static void searchByNewsText(News e) {

    }


}
