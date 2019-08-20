package chapter8;

/**
 * User Class is used as a Collection
 */
public class User implements Comparable<User> {
    private int id;
    private String name;
    
    /**
     * Default Constructors
     */
    public User () {
    }
    
    /**
     * parameterised constructor
     *
     * @param id   takes id of the user
     * @param name takes name of the user
     */
    public User (int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /**
     * Method compares the two name of the User and sort it by its name.
     *
     * @param user takes the name from the list and compared with the previous one
     * @return the name sorted by the compareTo method
     */
    @Override
    public int compareTo (User user) {
        return name.compareTo(user.name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * @return Information about a Current User object holding.
     */

    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
}
