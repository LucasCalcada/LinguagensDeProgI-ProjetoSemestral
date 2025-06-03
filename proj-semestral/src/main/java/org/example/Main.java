package org.example;

import java.sql.SQLException;

import org.example.database.DatabaseInit;
import org.example.screens.MainScreen;

public class Main {
  public static void main(String[] args) {
    try {
      DatabaseInit.InitializeDatabase();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    new MainScreen();
  }
}
