package chapter3.inheritance.aggregation;

/**
 * Address class used for taking address with city state and country.
 */
class Address {
    String city, state, country;
    
    /**
     * @param city    Takes the city
     * @param state   Takes the states
     * @param country Takes the country
     */
    public Address (String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }
}

public class Person {
    String fname, lname, mname;
    Address address;
    
    /**
     * @param fname   takes the Firstname
     * @param lname   takes the Lastname
     * @param mname   takes the MiddleName
     * @param address takes the Address
     */
    public Person (String fname, String lname, String mname, Address address) {
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.address = address;
    }
}
