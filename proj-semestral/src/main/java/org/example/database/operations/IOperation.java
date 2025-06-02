package org.example.database.operations;

import org.example.database.entities.DbEntity;
import org.example.objects.DataObject;

interface IOperation<T extends DataObject> {
  public DbEntity<T> create(T data);

  public DbEntity<T> read(int id);

  public DbEntity<T> update(int id, T data);

  public void delete(int id);
}
