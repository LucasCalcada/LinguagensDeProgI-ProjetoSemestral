package org.example.database.operations;

import java.sql.Connection;

import org.example.database.DbConnector;
import org.example.objects.DataObject;

public abstract class Operation<T extends DataObject> implements ICrud<T>, IListOperation<T> {
  protected Connection conn;

  public Operation() {
    conn = DbConnector.getInstance().dbConnection;
  }
}
