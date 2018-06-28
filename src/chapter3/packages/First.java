package chapter3.packages;

public class First {
    protected int b;
    private int a;

    public static void main(String[] args) {
        First f = new First();
        f.meth();
        f.meth2();
    }

    /**
     * This method is protected so it is only used in this package and
     * only in the child class from the outside packages.
     */
    protected void meth() {
        System.out.println("Hello, I am protected in " + getClass().getSimpleName());
    }

    /*
     * this method is private and it is only used within the class body.
     * outside of the class body it will not be used.
     * */
    private void meth2() {
        System.out.println("Hello, I am private in " + getClass().getSimpleName());
    }
}
