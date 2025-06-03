package org.example.screens.table;

import java.util.Arrays;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.example.database.entities.DbEntity;
import org.example.objects.DataObject;
import org.example.screens.table.builder.DataBuilderRegistry;
import org.example.screens.table.builder.ITableDataBuilder;

public class TableView {
  public static <T extends DataObject> JTable buildTable(Class<T> c, DbEntity<T>[] data) {
    ITableDataBuilder<T> dataBuilder = DataBuilderRegistry.getInstance().getDataBuilder(c);

    DefaultTableModel model = new DefaultTableModel(dataBuilder.dataObjectHeaders(), 0);
    for (DbEntity<T> d : data) {
      String[] row = dataBuilder.dataObjectToRow(d);
      model.addRow(row);
    }
    return new JTable(model);
  }
}
