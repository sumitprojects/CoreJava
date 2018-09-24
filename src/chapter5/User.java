package chapter5;

public class User {
    private int id;
    private String name;
  
  /**
   * Default Java Code
   */
  public User () {
  }
  
  /**
   * @param id   <h2>takes id as an argument</h2>
   * @param name <h2>takes name an argument</h2>
   */
  public User (int id, String name) {
    this.id = id;
    this.name = name;
  }
    
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
