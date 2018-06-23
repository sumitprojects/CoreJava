package chapter3.inheritance.aggregation;

class Address {
    String city, state, country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }
}

public class Person {
    String fname, lname, mname;
    Address address;

    public Person(String fname, String lname, String mname, Address address) {
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.address = address;
    }
}
