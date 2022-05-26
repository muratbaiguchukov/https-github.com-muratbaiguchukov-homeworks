package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    public void wash() {
        System.out.println("Пш-Пш" + getClass());
    }
}

class Plate extends Dish{}
class Wildcards{
    public static void washDishes(List<? extends Dish> dishes) {
        for(Dish d : dishes) {
            d.wash();
        }
    }

    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish());
        washDishes(dishes);
        List<Plate> plates = new ArrayList<>();
        plates.add(new Plate());
        washDishes(plates); // Everything is fine
    }

}
