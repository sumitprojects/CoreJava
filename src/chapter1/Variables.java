package chapter1;

public class Variables {
    static int m = 100;//static variable
	int data = 500;//instance variable

    public static void main(String[] args) {
        int data = 50;//local variable
        Variables v = new Variables();//object declaration
        System.out.println("Instance Var => v.data \t" + v.data);
        System.out.println(v);
        System.out.println("Static Var => m   \t" + m);
        System.out.println("Local Var => data  \t" + data);
    }
}
