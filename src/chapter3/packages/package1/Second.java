package chapter3.packages.package1;

import chapter3.packages.First;

public class Second {
    
    public static void main (String[] args) {
        First f = new First();
        Second sc = new Second();

//       f.meth();  // method is protected in First class so can't be used
//       f.meth2(); // method is private in First class so can't be used
    }
}
