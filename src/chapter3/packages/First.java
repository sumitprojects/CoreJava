package chapter3.packages;

import java.util.Arrays;

/*
 * Access Modifier	within class	within package	outside package by subclass only	outside package
 * Private	            Y	            N	                N	                                N
 * Default	            Y	            Y	                N	                                N
 * Protected	        Y	            Y	                Y	                                N
 * Public	            Y	            Y	                Y                                   Y
 * */
public class First {
    protected int b;
    private int a;
    
    public static void main (String[] args) {
        First f = new First();
        f.meth();
        f.meth2();
    }
    
    public void myMethod () {
        System.out.println("I am in First");
    }
    /**
     * This method is protected so it is only used in this package and
     * only in the child class from the outside packages.
     */
    protected void meth () {
        System.out.println("Hello, I am protected in " + Arrays.toString(getClass().getDeclaredMethods()));
    }
    
    /*
     * this method is private and it is only used within the class body.
     * outside of the class body it will not be used.
     * */
    private void meth2 () {
        System.out.println("Hello, I am private in " + getClass().getSimpleName());
    }
}
