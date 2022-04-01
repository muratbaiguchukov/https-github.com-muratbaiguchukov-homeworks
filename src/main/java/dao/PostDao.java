package dao;

import entities.Post;
import entities.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class PostDao {
    public List<Post> selectAll() {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        String sql = "SELECT * FROM posts";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Post.class);
        List<Post> posts = query.list();
        session.close();
        System.out.println("Найдено " + posts.size() + " постов");
        return posts;
    }
}
