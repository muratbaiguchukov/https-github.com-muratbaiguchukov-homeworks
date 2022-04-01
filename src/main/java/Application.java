import entity.*;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.Arrays;
import java.util.Objects;

public class Application {
    private static final Session hibernateSession =
            Objects.requireNonNull(HibernateUtils.
                            buildSessionFactorys()).
                    openSession();


    public static void main(String[] args) {
        hibernateSession.beginTransaction();

        Items items = Items.builder()
                .name("BREAD")
                .description("THE BLACK")
                .price(50)
                .build();

        Items items1 = Items.builder()
                .name("SHAMPOO")
                .description("FOR HAIR")
                .price(600)
                .build();

        Items items2 = Items.builder()
                .name("WINE")
                .description("RED")
                .price(1500)
                .build();

        User user = User.builder()
                .fullName("IVAN")
                .build();

        User user1 = User.builder()
                .fullName("PETR")
                .build();

        User user2 = User.builder()
                .fullName("SIDOR")
                .build();


        Basket basket = Basket.builder()
                .items(items)
                .user(user)
                .build();

        Basket basket1 = Basket.builder()
                .items(items1)
                .user(user1)
                .build();

        Basket basket2 = Basket.builder()
                .items(items2)
                .user(user2)
                .build();

        Categories categories = Categories.builder()
                .name("SOAP_WASHING")
                .build();

        Categories categories1 = Categories.builder()
                .name("BAKERY")
                .build();

        Categories categories2 = Categories.builder()
                .name("ALCOHOL")
                .build();

//        ItemsCategories itemsCategories = ItemsCategories.builder()
//                .items(items)
//                .categories(Arrays.asList(items, categories1))
//                .build();
//
//        ItemsCategories itemsCategories1 = ItemsCategories.builder()
//                .items(items1)
//                .categories(categories)
//                .build();
//
//        ItemsCategories itemsCategories2 = ItemsCategories.builder()
//                .items(items2)
//                .categories(categories2 )
//                .build();

        hibernateSession.save(items);
        hibernateSession.save(items1);
        hibernateSession.save(items2);
        hibernateSession.save(user);
        hibernateSession.save(user1);
        hibernateSession.save(user2);
        hibernateSession.save(basket);
        hibernateSession.save(basket1);
        hibernateSession.save(basket2);
        hibernateSession.save(categories);
        hibernateSession.save(categories1);
        hibernateSession.save(categories2);


        hibernateSession.getTransaction().commit();
        hibernateSession.close();


    }


}

