package chapter3.inheritance;

class BabyDog extends Dog {
    void weep() {
        System.out.println("weeping...");
    }
}

public class Multilevel {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Multilevel ");
        System.out.println("----------------------------------------------------------------");
        BabyDog d = new BabyDog();
        d.weep();
        d.bark();
        d.eat();
    }
}
