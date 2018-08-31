/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viki
 */
public class BookFun implements SQLInterface {

    private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
    private String jdbcUsername = "root";
    private String jdbcPassword = "mysql";
    private Connection con;
    private String sql;

    private void connect() {
        try {
            if (con == null || con.isClosed()) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
        } catch (SQLException e) {
            System.out.println("MSG => " + e);
        }
    }

    private void disconnect() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("MSG => " + e);
        }
    }

    @Override
    //insert fuction()
    public boolean insertData(Object object) {
        sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
        connect();
        Book book = (Book) object;
        boolean rowInserted = false;
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setFloat(3, book.getPrice());
            rowInserted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            disconnect();
        }

        return rowInserted;
    }

    @Override
    //update fuction()
    public boolean updateData(Object object) {
        sql = "UPDATE `book` SET `title`=?,`author`=?,`price`=? where book_id=?";
        connect();
        Book book = (Book) object;
        boolean rowupdated = false;
        try {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, book.getTitle());
            stat.setString(2, book.getAuthor());
            stat.setFloat(3, book.getPrice());
            stat.setInt(4, book.getId());
            rowupdated = stat.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            disconnect();
        }

        return rowupdated;

    }

    @Override
    public boolean deleteData(Object object) {
        sql = "DELETE FROM `book` WHERE `book_id`=?";
        connect();
        boolean deleteData = false;
        try {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setInt(1, 5);
            deleteData = stat.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            disconnect();
        }
        return deleteData;

    }

    public List<Book> listData() {
        List<Book> listBook = new ArrayList<>();

        String sql = "SELECT * FROM book";
        try {
            connect();

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");

                Book book = new Book(id, title, author, price);
                listBook.add(book);
            }
        } catch (SQLException e) {
            System.out.println("MSG => " + e);
        } finally {
            disconnect();
        }
        return listBook;

    }

    public void listData(String cols[]) {
        String colnames = String.join(",", cols);
        sql = "SELECT " + colnames + " FROM book";

        try {
            connect();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int i = 0;
                for (String col : cols) {
                    System.out.print(col + " = > " + resultSet.getString(col) + "\t");
                    i++;
                    if (i % 2 == 0) {
                        System.out.println("");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("MSG => " + e);
        } finally {
            disconnect();
        }
    }

    public static void main(String[] args) {
        BookFun bk = new BookFun();
        Book book = new Book("kite 2", "sumit", (float) 200.22);
        System.out.println("inserted book " + bk.insertData(book));
        book = new Book(1, "world 1", "sumit", (float) 200);
        System.out.println(bk.updateData(book));
        //System.out.println(bk.deleteData(new String[]{"title", "author"}));
    }
}
