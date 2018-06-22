package chapter3.classobjects;

class Employee {
    int id;
    String name;
}

public class OutsideMain {
    public static void main(String[] args) {
        Employee s1 = new Employee();
        Employee s2 = new Employee();
        s1.id = 1;
        s1.name = "sumit";

        s2.id = 2;
        s2.name = "sam";
        System.out.println(s1.id + " " + s1.name);
        System.out.println(s2.id + " " + s2.name);
    }
}
