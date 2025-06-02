package org.example.database.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.objects.DataObject;

@FunctionalInterface
public interface DataObjectMapper<T extends DataObject> {
  T map(ResultSet rs) throws SQLException;
}
