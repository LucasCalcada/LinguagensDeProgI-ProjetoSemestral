package org.example.database.operations;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import org.example.database.entities.DbEntity;
import org.example.database.mappers.RoomMapper;
import org.example.objects.Room;
import org.example.objects.Room.RoomStatus;

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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
}
