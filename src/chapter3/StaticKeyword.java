package chapter3;

public class StaticKeyword {
    static int counter = 0;
    
    static {
        System.out.println("static block is invoked");
    }
    
    static {
        System.out.println("static block 2 is invoked");
        //End of the program
        //System.exit(0);
    }

    public StaticKeyword() {
        counter++;
        System.out.println(counter);
    }
    
    static {
        System.out.println("static block 3 is invoked");
    }

    public static void main(String args[]) {
        StaticKeyword c1 = new StaticKeyword();
        A.disp();
        StaticKeyword c2 = new StaticKeyword();
        StaticKeyword c3 = new StaticKeyword();
    
    }
}

class A {
    static void disp () {
        System.out.println("test");
    }
}