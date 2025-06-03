package org.example.screens.table.builder;

import org.example.database.entities.DbEntity;
import org.example.objects.DataObject;

public interface ITableDataBuilder<T extends DataObject> {
  public String[] dataObjectHeaders();

  public String[] dataObjectToRow(DbEntity<T> obj);
}
