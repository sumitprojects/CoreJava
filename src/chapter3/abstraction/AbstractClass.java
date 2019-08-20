package chapter3.abstraction;

/*
 * Abstract class is not fully hidden.
 *
 * it will be hidden from 0 to 100%.
 *
 * abstract keyword is used for declaring abstract method and it is forcefully implemented in each child class
 * */
abstract class Methods {
    /*
     * meth mothod is abstract(no body method)
     * */
    abstract void meth ();
    
    /**
     * power method n^pow
     *
     * @param n   takes number
     * @param pow exponential power of the given number
     * @return returns the power of the given number
     */
    long power (long n, int pow) {
        if (pow == 1) {
            return n;
        } else {
            return n * power(n, --pow);
        }
    }

}

public class AbstractClass extends Methods {
    public static void main (String[] args) {
        Methods m = new AbstractClass();
        m.meth();
        System.out.println(m.power(10, 5));
    }


    @Override
    void meth () {
        System.out.println("I am force fully implemented.");
    }
}
