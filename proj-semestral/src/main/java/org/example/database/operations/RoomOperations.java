package org.example.database.operations;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import org.example.database.entities.DbEntity;
import org.example.database.mappers.RoomMapper;
import org.example.objects.Room;

public class RoomOperations extends Operation<Room> {
  @Override
  public DbEntity<Room> create(Room data) {
    String sql = "INSERT INTO rooms (room_name, daily_rate, single_bed_count, double_bed_count, status) VALUES (?, ?, ?, ?, ?)";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stm.setString(1, data.getRoomName());
      stm.setInt(2, data.getDailyRate());
      stm.setInt(3, data.getSingleBedCount());
      stm.setInt(4, data.getDoubleBedCount());
      stm.setString(5, data.getStatus().name());

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
  public DbEntity<Room> read(int id) {
    String sql = "SELECT * FROM rooms WHERE id = ?";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, id);
      ResultSet rs = stm.executeQuery();

      // Checa se a query retornou algum resultado
      if (!rs.next()) {
        return null;
      }

      // Constrói a Room a partir do resultado da query
      Room entry = RoomMapper.Instance.map(rs);

      return new DbEntity<Room>(id, entry);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DbEntity<Room> update(int id, Room data) {
    String sql = "UPDATE rooms SET room_name = ?, daily_rate = ?, single_bed_count = ?, double_bed_count = ?, status = ? WHERE id = ?";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setString(1, data.getRoomName());
      stm.setInt(2, data.getDailyRate());
      stm.setInt(3, data.getSingleBedCount());
      stm.setInt(4, data.getDoubleBedCount());
      stm.setString(5, data.getStatus().name());
      stm.setInt(6, id);

      stm.executeUpdate();

      return read(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(int id) {
    String sql = "DELETE FROM rooms WHERE id = ?";
    try {
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, id);
      stm.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DbEntity<Room>[] list() {
    String sql = "SELECT * FROM rooms";
    try {
      PreparedStatement stm = conn.prepareStatement(sql);
      ResultSet rs = stm.executeQuery();
      List<DbEntity<Room>> results = new ArrayList<>();
      while (rs.next()) {
        Room entry = RoomMapper.Instance.map(rs);
        DbEntity<Room> row = new DbEntity<Room>(rs.getInt("id"), entry);
        results.add(row);
      }
      return results.toArray(new DbEntity[0]);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
