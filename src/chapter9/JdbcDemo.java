package chapter9;

import chapter9.model.Book;
import chapter9.model.BookFunctions;

public class JdbcDemo {
    private static Book book = new Book("java2", "oracle", 200);
    private static BookFunctions bookFunctions = new BookFunctions();
    
    public static void main (String[] args) {
        boolean result = false;
        
        try {
            result = bookFunctions.insertData(book);
            if (result) {
                System.out.println("Successful");
            } else {
                System.err.println("Unsuccessful");
            }
        } catch (Exception e) {
            System.err.println("Message: " + e);
        }
    }
}
