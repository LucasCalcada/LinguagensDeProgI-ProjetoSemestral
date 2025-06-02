package org.example.database.mappers;

import org.example.objects.Sale;

public class SaleMapper {
  public static final DataObjectMapper<Sale> Instance = rs -> {
    Sale sale = new Sale();
    sale.setProductId(rs.getInt("product"));
    sale.setAmount(rs.getInt("amount"));
    sale.setPrice(rs.getInt("price"));
    sale.setBookingId(rs.getInt("booking"));
    return sale;
  };
}
