package chapter3.polymorphism;
/*
* Runtime polymorphism with Dynamic Binding
*
*
* */
class Bank{
    float getRateOfInterest(){
        return 0.0f;
    }
}
class SBI extends Bank{
    @Override
    float getRateOfInterest() {
        return 8.7f;
    }
}

class AXIS extends Bank{
    @Override
    float getRateOfInterest() {
        return 9.7f;
    }
}

class ICICI extends Bank{
    @Override
    float getRateOfInterest() {
        return 10.7f;
    }
}


public class RuntimePolymorphism {
    public static void main(String[] args) {
        Bank b;//upcasting
    
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Runtime Polymorphism ");
        System.out.println("----------------------------------------------------------------");
        b = new SBI();//Runtime polymorphism with Dynamic Binding
        System.out.println("SBI Rate of Interest = \t" + b.getRateOfInterest());
        b = new AXIS();
        System.out.println("AXIX Rate of Interest = \t" + b.getRateOfInterest());
        b = new ICICI();
        System.out.println("ICICI Rate of Interest =\t" + b.getRateOfInterest());
        System.out.println("----------------------------------------------------------------");
    }
}
