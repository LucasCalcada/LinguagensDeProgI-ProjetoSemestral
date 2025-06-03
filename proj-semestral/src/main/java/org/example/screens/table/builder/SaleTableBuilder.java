package org.example.screens.table.builder;

import org.example.database.entities.DbEntity;
import org.example.objects.Sale;

public class SaleTableBuilder implements ITableDataBuilder<Sale> {
  @Override
  public String[] dataObjectHeaders() {
    return new String[] {
        "Id", "Id do Produto", "Quantidade", "Valor", "Id Reserva"
    };
  }

  @Override
  public String[] dataObjectToRow(DbEntity<Sale> obj) {
    String id = Integer.toString(obj.getId());

    Sale dataObj = obj.getData();
    String productId = Integer.toString(dataObj.getProductId());
    String amount = Integer.toString(dataObj.getAmount());
    String price = Integer.toString(dataObj.getAmount());
    String booking = Integer.toString(dataObj.getBookingId());

    return new String[] {
        id, productId, amount, price, booking
    };
  }
}
