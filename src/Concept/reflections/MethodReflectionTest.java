package Concept.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodReflectionTest {
    public static void main(String[] args) {
        Class birdClass = Bird.class;
//        Method[] methods = birdClass.getDeclaredMethods();
        Field[] fields = birdClass.getDeclaredFields();

//        for (Method method : methods) {
//            System.out.println("method name : " + method.getName());
//            System.out.println("return type : " + method.getReturnType());
//            System.out.println("class name : " + method.getDeclaringClass());
//        }

        for (Field field : fields) {
            System.out.println("field : "+field.getName());
            System.out.println("type : "+field.getType());
        }
    }
}

class Bird {
    public String breed;
    private boolean canSwim;

    public void fly() {
        System.out.println("fly");
    }

    private void eat() {
        System.out.println("eat");
    }
}
