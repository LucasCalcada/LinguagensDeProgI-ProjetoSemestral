package org.example.database.operations;

import java.sql.Connection;

import org.example.database.DbConnector;

public class Operation {
  protected Connection conn;

  public Operation() {
    conn = DbConnector.getInstance().dbConnection;
  }
}
