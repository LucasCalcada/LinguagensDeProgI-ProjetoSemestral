package org.example.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.example.Environment.Environment;

public class DbConnector {
  public static DbConnector Instance;

  public final Connection dbConnection;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private DbConnector() {
    try {
      dbConnection = connect();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static DbConnector getInstance() {
    if (Instance == null) {
      Instance = new DbConnector();
    }
    return Instance;
  }

  public void close() {
    try {
      dbConnection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private Connection connect() throws SQLException {
    Environment env = Environment.getInstance();
    String address = "jdbc:mysql://" + env.dbAddress + ":" + env.dbPort;
    String params = "?user=" + env.dbUser + "&password=" + env.dbPasswd;
    System.out.println(address + "/" + env.dbName + params);
    return DriverManager.getConnection(address + "/" + params);
  }
}
