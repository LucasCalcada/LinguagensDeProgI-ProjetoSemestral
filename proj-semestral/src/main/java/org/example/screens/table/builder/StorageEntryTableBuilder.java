package org.example.screens.table.builder;

import org.example.database.entities.DbEntity;
import org.example.objects.StorageEntry;

public class StorageEntryTableBuilder implements ITableDataBuilder<StorageEntry> {
  @Override
  public String[] dataObjectHeaders() {
    return new String[] {
        "Id", "Id Produto", "Operação", "Quantidade"
    };
  }

  @Override
  public String[] dataObjectToRow(DbEntity<StorageEntry> obj) {
    String id = Integer.toString(obj.getId());

    StorageEntry dataObj = obj.getData();
    String productId = Integer.toString(dataObj.getProductId());
    String operationType = dataObj.getEntryType().toString();
    String amount = Integer.toString(dataObj.getAmount());

    return new String[] {
        id, productId, operationType, amount
    };
  }
}
