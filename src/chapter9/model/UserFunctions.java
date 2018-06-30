package chapter9.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserFunctions {
  private final String url = "";
  private final String user = "root";
  private final String password = "mysql";
  private Connection connection;
  private PreparedStatement sql;

  protected void connect() {
    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  protected void disconnect() {
    try {
      if (!connection.isClosed() && !connection.equals("")) {
        connection.close();
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
}
