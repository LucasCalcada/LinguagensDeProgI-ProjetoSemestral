package org.example.database.operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.example.database.entities.DbEntity;
import org.example.database.mappers.SaleMapper;
import org.example.objects.Sale;

public class SaleOperations extends Operation<Sale> {
  @Override
  public DbEntity<Sale> create(Sale data) {
    String sql = "INSERT INTO sales (product, amount, price, booking) VALUES (?, ?, ?, ?)";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stm.setInt(1, data.getProductId());
      stm.setInt(2, data.getAmount());
      stm.setInt(3, data.getPrice());
      stm.setInt(4, data.getBookingId());

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
  public DbEntity<Sale> read(int id) {
    String sql = "SELECT * FROM sales WHERE id = ?";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, id);
      ResultSet rs = stm.executeQuery();

      // Checa se a query retornou algum resultado
      if (!rs.next()) {
        return null;
      }

      // Constrói a Sale a partir do resultado da query
      Sale entry = SaleMapper.Instance.map(rs);

      return new DbEntity<Sale>(id, entry);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DbEntity<Sale> update(int id, Sale data) {
    String sql = "UPDATE sales SET product = ?, amount = ?, price = ?, booking = ? WHERE id = ?";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, data.getProductId());
      stm.setInt(2, data.getAmount());
      stm.setInt(3, data.getPrice());
      stm.setInt(4, data.getBookingId());
      stm.setInt(5, id);

      stm.executeUpdate();

      return read(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
}
