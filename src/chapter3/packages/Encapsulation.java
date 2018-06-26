package chapter3.packages;

public class Encapsulation {
    private String data;

    public Encapsulation() {
    }

    //encapsulation with constructor
    public Encapsulation(String data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Encapsulation e1 = new Encapsulation();
        Encapsulation e2 = new Encapsulation("Sumit");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Encapsulation");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Blank Constructor => " + e1.getData());
        System.out.println("Parameter Constructor => " + e2.getData());
    }

    /*
     * Encapsulation using Getters and Setters
     * */
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
