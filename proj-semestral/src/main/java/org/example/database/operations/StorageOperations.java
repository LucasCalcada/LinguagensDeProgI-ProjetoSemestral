package org.example.database.operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.example.database.entities.DbEntity;
import org.example.database.mappers.StorageEntryMapper;
import org.example.objects.StorageEntry;
import org.example.objects.StorageEntry.EntryType;;

public class StorageOperations extends Operation<StorageEntry> {
  @Override
  public DbEntity<StorageEntry> create(StorageEntry data) {
    String sql = "INSERT INTO storage_entries (product, amount, price) VALUES (?, ?, ?)";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stm.setInt(1, data.getProductId());
      stm.setInt(2, data.getAmount());
      stm.setString(3, data.getEntryType().name());

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
  public DbEntity<StorageEntry> read(int id) {
    String sql = "SELECT * FROM storage_entries WHERE id = ?";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, id);
      ResultSet rs = stm.executeQuery();

      // Checa se a query retornou algum resultado
      if (!rs.next()) {
        return null;
      }

      // Constrói o StorageEntry a partir do resultado da query
      StorageEntry entry = StorageEntryMapper.Instance.map(rs);

      return new DbEntity<StorageEntry>(id, entry);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DbEntity<StorageEntry> update(int id, StorageEntry data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
}
