package org.example.database.operations;

import org.example.database.entities.DbEntity;
import org.example.objects.DataObject;

public interface IListOperation<T extends DataObject> {
  public DbEntity<T>[] list();
}
