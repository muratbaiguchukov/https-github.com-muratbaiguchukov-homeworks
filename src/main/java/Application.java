import entities.Category;
import entities.News;
import org.hibernate.Session;
import util.HibernateUtil;

import java.time.LocalTime;
import java.util.Objects;

public class Application {
    private static final Session hibernateSession =
            Objects.requireNonNull(HibernateUtil.
                            buildSessionFactory()).
                    openSession();


    public static void main(String[] args) {
        hibernateSession.beginTransaction();

        Category category = Category.builder()
                .name("POLITICS")
                .build();

        Category category1 = Category.builder()
                .name("ECONOMY")
                .build();

        Category category2 = Category.builder()
                .name("SPORT")
                .build();

        News news = News.builder()
                .title("Обзор 2-го тура КПЛ")
                .newsText("Завершился 2-й тур чемпионата Кыргызстана по футболу.")
                .category(category2)
                .publicationTime(LocalTime.now())
                .build();

        News news1 = News.builder()
                .title("Политическое устройство Кыргызстана")
                .newsText("В 2021 году состоялись выборы в ЖК Кыргызстана")
                .category(category)
                .publicationTime(LocalTime.now())
                .build();

        News news2 = News.builder()
                .title("Экономика на спаде")
                .newsText("В связит с пандемией коронавируса мировая экономика ощущает спад")
                .category(category1)
                .publicationTime(LocalTime.now())
                .build();

        hibernateSession.save(category);
        hibernateSession.save(category1);
        hibernateSession.save(category2);
        hibernateSession.save(news);
        hibernateSession.save(news1);
        hibernateSession.save(news2);


        hibernateSession.getTransaction().commit();
        hibernateSession.close();


    }


}

