package chapter3.classobjects;

public class Constructors {
    int id;
    String name;

    public Constructors() {
    }

    public Constructors(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Constructors c = new Constructors();
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t default constructor Constructors c = new Constructors();" + c);
        System.out.println("----------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------");
        Constructors c1 = new Constructors(10, "sumit");
        System.out.println("\t\t overrided parameter constructor Constructors c = new Constructors(10,sumit); ");
        System.out.println("\t\t " + c1.id + "\t" + c1.name);
        System.out.println("----------------------------------------------------------------");

    }
}
