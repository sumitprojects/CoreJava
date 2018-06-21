package chapter3.classobjects;

public class SimpleClass {
    int id;//field or data member or instance variable
    String name;

    public static void main(String[] args) {
        SimpleClass s1 = new SimpleClass();//creating an object of SimpleClass
        System.out.println(s1.id);//accessing member through reference variable
        System.out.println(s1.name);

        new SimpleClass();//anonymous object
    }
}
