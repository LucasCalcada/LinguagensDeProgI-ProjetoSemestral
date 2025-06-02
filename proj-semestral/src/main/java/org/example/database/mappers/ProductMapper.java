package org.example.database.mappers;

import org.example.objects.Product;

public class ProductMapper {
  public static final DataObjectMapper<Product> Instance = rs -> {
    Product product = new Product();
    product.setProductName(rs.getString("product_name"));
    product.setSellPrice(rs.getInt("sell_price"));
    product.setActive(rs.getBoolean("active"));
    return product;
  };
}
