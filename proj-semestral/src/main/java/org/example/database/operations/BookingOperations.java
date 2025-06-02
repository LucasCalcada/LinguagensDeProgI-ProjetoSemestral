package org.example.database.operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.example.database.entities.DbEntity;
import org.example.objects.Booking;

public class BookingOperations extends Operation implements IOperation<Booking> {
  @Override
  public DbEntity<Booking> create(Booking data) {
    String sql = "INSERT INTO bookings (room, booker_name, booker_cpf, booker_phone, client_count, booking_start, booking_end) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stm.setInt(1, data.getRoom());
      stm.setString(2, data.getBookerName());
      stm.setString(3, data.getBookerCpf());
      stm.setString(4, data.getBookerPhone());
      stm.setInt(5, data.getClientCount());
      stm.setDate(6, data.getBookingStart());
      stm.setDate(7, data.getBookingEnd());

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
  public DbEntity<Booking> read(int id) {
    String sql = "SELECT * FROM bookings WHERE id = ?";
    try {
      // Constrói a query
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, id);
      ResultSet rs = stm.executeQuery();

      // Checa se a query retornou algum resultado
      if (!rs.next()) {
        return null;
      }

      // Constrói o Booking a partir do resultado da query
      Booking entry = new Booking();
      entry.setRoom(rs.getInt("room"));
      entry.setBookerName(rs.getString("booker_name"));
      entry.setBookerCpf(rs.getString("booker_cpf"));
      entry.setBookerPhone(rs.getString("booker_phone"));
      entry.setClientCount(rs.getInt("client_count"));
      entry.setBookingStart(rs.getDate("booking_start"));
      entry.setBookingEnd(rs.getDate("booking_end"));

      return new DbEntity<Booking>(id, entry);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DbEntity<Booking> update(int id, Booking data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
}
