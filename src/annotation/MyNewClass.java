package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotationType {
    String name ();
    
    int age ();
}

@MyAnnotationType(name = "Sumit more", age = 26)
public class MyNewClass {
    
    public static void main (String[] args) {
        myAnnotationAction();
    }
    
    @MyAnnotationType(name = "Sumit", age = 25)
    public static void myAnnotationAction () {
        MyNewClass myNewClass = new MyNewClass();
        try {
            Method method = myNewClass.getClass().getMethod("myAnnotationAction");
            MyAnnotationType ann = method.getAnnotation(MyAnnotationType.class);
            System.out.println("name : " + ann.name() + "\n" +
                    "age : " + ann.age());
        } catch (NoSuchMethodException e) {
            System.err.println("Method not Found");
        }
    }
}
