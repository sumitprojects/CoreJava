package chapter9.model;

/**
 * This is book bean class.
 *
 * @author Sumit
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private float price;
    
    public Book () {
    }
    
    /*
     * @param id takes id as argument for book.
     */
    public Book (int id) {
        this.id = id;
    }
    
    
    /**
     * @param id     book id
     * @param title  book name
     * @param author book author
     * @param price  book price
     */
    public Book (int id, String title, String author, float price) {
        this(title, author, price);
        this.id = id;
    }
    
    
    /**
     * @param title  book name
     * @param author book author
     * @param price  book price
     */
    public Book (String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public String getTitle () {
        return title;
    }
    
    public void setTitle (String title) {
        this.title = title;
    }
    
    public String getAuthor () {
        return author;
    }
    
    public void setAuthor (String author) {
        this.author = author;
    }
    
    public float getPrice () {
        return price;
    }
    
    public void setPrice (float price) {
        this.price = price;
    }
    
    
}
