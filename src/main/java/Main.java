import model.Dog;
import model.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        task7();
    }

    static void task1() {
        Dog existDog = new Dog();
        existDog.setName("Alt");
        existDog.setAge(12);

        Dog notExistDog = null;

        Optional<Dog> existOfDog = Optional.of(existDog);
        Optional<Dog> existOfNullableDog = Optional.ofNullable(existDog);

        Optional<Dog> notExistOfNullableDog = Optional.ofNullable(notExistDog);
        Optional<Dog> notExistOfDog = Optional.of(notExistDog);
    }

    static void task2() {
        Dog existDog = new Dog();
        existDog.setName("Alt");
        existDog.setAge(12);

        Optional<Dog> existOfDog = Optional.of(existDog);
        Optional<Dog> notExistOfDog = Optional.ofNullable(null);

        if (notExistOfDog.isPresent()) {
            System.out.println(existOfDog.get().getName());
        } else {
            Dog defaultDog = new Dog();
            defaultDog.setName("Default");
            defaultDog.setAge(12);
            System.out.println(defaultDog.getName());
        }
    }

    static void task3() {
        // создали объект
        Dog existDog = new Dog();
        existDog.setName("Alt");
        existDog.setAge(12);

        // поместили объект в контейнер
        Optional<Dog> existOfDog = Optional.ofNullable(existDog);

        // Когда в контейнере есть объект, то он вернет этот объект, иначе вернет объект из метода orElseGet
        Dog newTempDog = existOfDog.orElseGet(() -> {
            Dog temp = new Dog();
            temp.setName("OrElseGet");
            temp.setAge(123);
            return temp;
        });
        System.out.println(newTempDog.getName());
    }

    static void task4() {
        Integer[] arrayInteger = {1, 2, 3, 4, 5, 6, 7};
        // Stream version
        Arrays.stream(arrayInteger).forEach(item -> System.out.println(item * item));

        // Old version
        for (Integer item : arrayInteger) {
            System.out.println(item * item);
        }
    }

    static void task5() {
        String text = "Hello World Alex";
        Stream.of(text.toCharArray()).forEach(character -> {

        });
    }

    static void task6() {
        Student petrov = new Student(1, "Петров");
        Student egorov = new Student(2, "Егоров");
        Student test = new Student(3, "test");
        Student test2 = new Student(4, "test2");
        Student test3 = new Student(5, "test3");
        List<Student> studentList = List.of(petrov, egorov, test, test2, test3);

        // Stream version
        studentList
                .stream()
                .map(item ->item.getFio())
                .forEach(item -> System.out.println(item));

        // можно сделать следующим образом в проектах
        //  studentList
        //                .stream()
        //                .map(item ->{
        //                StudentModel model = new StudentModel();
        //                model.setName(item.getFio());
        //                return model;
        //                })
        //                .forEach(item -> System.out.println(item));

        // Old version
        List<String> fios = new ArrayList<>();
        for (Student st : studentList) {
            fios.add(st.getFio());
        }
        for (String fio : fios) {
            System.out.println(fio);
        }
    }

    static void task7(){
        Student petrov = new Student(1, "Петров");
        Student egorov = new Student(2, "Егоров");
        Student test = new Student(3, "test");
        Student test2 = new Student(4, "test2");
        Student test3 = new Student(5, "test3");
        List<Student> studentList = List.of(petrov, egorov, test, test2, test3);

        List<String> fios = studentList.stream()
                .map(item->item.getFio())
                .collect(Collectors.toList());

        Set<String> fioSet = studentList.stream()
                .map(item->item.getFio())
                .collect(Collectors.toSet());

        List<Student> idCreater5 = studentList.stream()
                .filter(item -> item.getId() > 3 || item.getFio().equals("Петров"))
                .collect(Collectors.toList());

        // можно чередовать промежуточные операторы следующим образом
        //  List<Student> idCreater5 = studentList.stream()
        //                .filter(item -> item.getId() > 3 || item.getFio().equals("Петров"))
        //                .map()
        //                .filter()
        //                .map()
        //                .collect(Collectors.toList());

        idCreater5.forEach(item-> System.out.println(item.getId()));
    }

}
