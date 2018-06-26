package chapter3;

public class StaticKeyword {
    static int counter = 0;

    static {
        System.out.println("static block is invoked");
    }

    public StaticKeyword() {
        counter++;
        System.out.println(counter);
    }

    public static void main(String args[]) {
        StaticKeyword c1 = new StaticKeyword();
        StaticKeyword c2 = new StaticKeyword();
        StaticKeyword c3 = new StaticKeyword();
    }
}
