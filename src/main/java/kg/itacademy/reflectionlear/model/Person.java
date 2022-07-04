package kg.itacademy.reflectionlear.model;

import kg.itacademy.reflectionlear.annotations.MethodInfo;
import kg.itacademy.reflectionlear.annotations.MyAnnotation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.annotation.RetentionPolicy;

@Getter
@Setter
@ToString
@MethodInfo
@MyAnnotation
public class Person {
    public Long publicField;
    private Long id;
    private String fullName;

    @MethodInfo
        public void testMethod() {
        System.out.println("I'm test");
    }
}
