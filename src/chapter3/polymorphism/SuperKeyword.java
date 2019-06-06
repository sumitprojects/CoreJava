package chapter3.polymorphism;

/*Usage of java super Keyword
super can be used to refer immediate parent class instance variable.
super can be used to invoke immediate parent class method.
super() can be used to invoke immediate parent class constructor.
*/

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void Display() {
        System.out.println("\t " + id + " \t\t " + name);
        System.out.println("----------------------------------------------------------------");
    }
}

class Employee extends Person {
    float salary;

    public Employee(int id, String name, float salary) {
        super(id, name);//As an constructor call
        this.salary = salary;
    }

    public void Display() {
		super.Display();
		super.id = 100;
        System.out.println("\t " + id + " \t\t " + name + " \t\t " + salary);
        System.out.println("----------------------------------------------------------------");
    }
}

public class SuperKeyword {
    public static void main(String[] args) {
        Employee e = new Employee(1, "Sumit", 9000000);
        Employee e2 = new Employee(2, "Amit", 1000000);
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Super Keyword ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t ID \t\t NAME \t\t SALARY \t");
        e.Display();
        e2.Display();

    }
}
