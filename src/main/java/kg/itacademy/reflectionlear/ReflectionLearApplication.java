package kg.itacademy.reflectionlear;

import kg.itacademy.reflectionlear.annotations.MethodInfo;
import kg.itacademy.reflectionlear.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@SpringBootApplication
public class ReflectionLearApplication {

	public static void main(String[] args) throws ClassNotFoundException {

//		SpringApplication.run(ReflectionLearApplication.class, args);
//		Person person = new Person();
//		person.setId(1l);
//		person.setFullName("Tom Cruz");
//		System.out.println(person);
//
//		Class c1 = Person.class;
//		System.out.println(c1);
//
//		Class c2 = person.getClass();
//		System.out.println(c2);
//
//		Class c3 = Class.forName("modelPerson");
//		System.out.println(c3);
//
//		Method[] methods = c3.getMethods();
//		for (Method method : methods) {
//			System.out.println("------------------------------------");
//			System.out.println(method.getName());
//			System.out.println(method.getReturnType());
//			System.out.println(Arrays.toString(method.getParameterAnnotations()));
//			System.out.println("------------------------------------");
//
//		}
//
//		System.out.println("---------------Field----------------");
//		Field[] fields = c3.getFields();
//		for (Field field : fields) {
//			System.out.println(field.getName());
//			System.out.println(field.getType());
//			System.out.println("-------------------------------");
//
//		}
//
//		System.out.println("---------------Field Private----------------");
//		Field[] fieldPrivates = c3.getDeclaredFields();
//		for (Field field : fieldPrivates) {
//			System.out.println(field.getName());
//			System.out.println(field.getType());
//			System.out.println("-------------------------------");
//
//		}
//
//		Annotation[] annotations = c3.getAnnotations();
//		for (Annotation annotation : annotations) {
//		if(annotation instanceof MethodInfo) {
//			System.out.println("Yes");
//		}
//
//		}
//
//		Method[] methodAnnotation = c3.getMethods();
//		for (Method m : methodAnnotation) {
//			Annotation[] annotations1 = m.getAnnotations();
//			for (Annotation an : annotations1) {
//				if (an instanceof MethodInfo){
//					System.out.println("Yes");
//				}
//
//			}
//		}
		Object asdfasdf = new Person();
		Object asdfasdfff = new Cat();

		if(asdfasdf instanceof Person){
			System.out.println("Hi, man!");
		}



	}

}
