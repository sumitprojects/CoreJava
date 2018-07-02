package chapter3.packages.package2;

import chapter3.packages.First;

public class Third extends First {
    public static void main (String[] args) {
        First f = new Third();
        //f.b = 10;
        //upcasting couldnot call the method and var which are declared as protected and private in another packages
        // method is private in First class so can't be used
        Third t = new Third();
        t.meth();
        
        t.b = 20;//it is possible to change the b because it is used by its child

//        f.meth();// C.E. because parent method is protected by itself.
    }
    
    @Override
    protected void meth () {
        super.meth();//inherit by third class so class name will be changed.
        System.out.println("Hello, I am protected and extended from the " +
                "" + getClass().getSuperclass().getSimpleName() + " in " +
                "" + getClass().getSimpleName() + ".");
    }
}
