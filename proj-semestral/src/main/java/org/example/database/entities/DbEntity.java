package org.example.database.entities;

import org.example.objects.DataObject;

public class DbEntity<T extends DataObject> {
  private final int id;
  private final T data;

  public DbEntity(int id, T data) {
    this.id = id;
    this.data = data;
  }

  public int getId() {
    return id;
  }

  public T getData() {
    return data;
  }
}
