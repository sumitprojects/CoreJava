package chapter9.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookFunctions implements CrudInterface<Book> {
    private final String url = "";
    private final String user = "root";
    private final String password = "mysql";
    private Connection connection;
    private PreparedStatement sql;
    
    /**
     * JDBC connection opens connection objects.
     */
    private void connect () {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /**
     * checks the connection object and close the connection.
     */
    private void disconnect () {
        try {
            if (!connection.isClosed() && !connection.equals("")) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public boolean insertData (Book book) {
        String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
        connect();
        boolean rowInserted = false;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setFloat(3, book.getPrice());
            rowInserted = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        disconnect();
        return rowInserted;
    }
    
    @Override
    public ArrayList<Book> selectData () {
        return null;
    }
}
