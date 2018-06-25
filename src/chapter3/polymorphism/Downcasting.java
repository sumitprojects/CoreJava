package chapter3.polymorphism;

class Account {
}

class Customers extends Account {
    void bal(Account a) {
        if (a instanceof Customers) {
            Customers c = (Customers) a;
            System.out.println("Hello I am down casted");
            c.show();
        }
    }

    void show() {
        System.out.println("downcasted");
    }
}

public class Downcasting {

    public static void main(String[] args) {
        Account a = new Account();
        Account c = new Customers();//only access shared method
        //c.show();
        new Customers().bal(c);
    }
}
