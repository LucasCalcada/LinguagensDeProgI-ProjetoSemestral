package org.example.database.operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.example.database.entities.DbEntity;
import org.example.database.mappers.ProductMapper;
import org.example.objects.Product;

public class ProductOperations extends Operation<Product> {
  @Override
  public DbEntity<Product> create(Product data) {
    String sql = "INSERT INTO products (product_name, sell_price, active) VALUES (?, ?, ?)";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stm.setString(1, data.getProductName());
      stm.setInt(2, data.getSellPrice());
      stm.setBoolean(3, data.isActive());

      stm.executeUpdate();

      ResultSet generated = stm.getGeneratedKeys();
      if (!generated.next()) {
        throw new Exception("Entry could not be created");
      }

      // Retorna a entrada criada
      return read(generated.getInt(1));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DbEntity<Product> read(int id) {
    String sql = "SELECT * FROM products WHERE id = ?";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, id);
      ResultSet rs = stm.executeQuery();

      // Checa se a query retornou algum resultado
      if (!rs.next()) {
        return null;
      }

      // Constrói o Product a partir do resultado da query
      Product entry = ProductMapper.Instance.map(rs);

      return new DbEntity<Product>(id, entry);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DbEntity<Product> update(int id, Product data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
}
