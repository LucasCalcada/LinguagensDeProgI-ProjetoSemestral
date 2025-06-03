package org.example.screens.table.builder;

import org.example.database.entities.DbEntity;
import org.example.objects.Product;

public class ProductTableBuilder implements ITableDataBuilder<Product> {
  @Override
  public String[] dataObjectHeaders() {
    return new String[] {
        "Id", "Produto", "Valor de venda", "Ativo"
    };
  }

  @Override
  public String[] dataObjectToRow(DbEntity<Product> obj) {
    String id = Integer.toString(obj.getId());

    Product dataObj = obj.getData();
    String productName = dataObj.getProductName();
    String sellPrice = Integer.toString(dataObj.getSellPrice());
    String active = Boolean.toString(dataObj.isActive());

    return new String[] {
        id, productName, sellPrice, active
    };
  }
}
