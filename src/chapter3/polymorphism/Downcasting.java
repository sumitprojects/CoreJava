package chapter3.polymorphism;

class Account {
}

class User extends Account {
}

class Customers extends Account {
  /*
   * Downcasting as well as checking the proper class relation.
   * */
  void bal(Account a) {
    if (a instanceof Customers) {
      Customers c = (Customers) a;
      System.out.println("Hello I am down casted");
      c.show();
    } else {
      System.err.println("You have given Wrong objects.");
    }
//        Customers c = (Customers) a;
//        System.out.println("Hello I am down casted");
//        c.show();

  }

    void show() {
        System.out.println("downcasted");
    }
}

public class Downcasting {

    public static void main(String[] args) {
        Account a = new Account();
      /*
       * new Customer()
       * new Account()
       * */
        Account c = new Customers();//only access shared method
      Account u = new User();
        //c.show();

      /*
       * Account class passed as Customer
       * */
      new Customers().bal(a);

      /*
       * Account Class passed as User in Customer class
       * */
      new Customers().bal(u);
    }
}
