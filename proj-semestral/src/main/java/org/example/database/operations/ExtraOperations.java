package org.example.database.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.database.DbConnector;
import org.example.database.mappers.SaleMapper;
import org.example.objects.Booking;
import org.example.objects.Room;
import org.example.objects.Sale;

public class ExtraOperations {
  protected Connection conn;

  public ExtraOperations() {
    conn = DbConnector.getInstance().dbConnection;
  }

  public void OccupyRoomByBooking(Booking booking) {
    String sql = "UPDATE rooms SET status = OCCUPIED WHERE id = ?";
    try {
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, booking.getRoom());
      stm.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public class BookingSummary {
    public Room room;
    public Booking booking;
    public List<Sale> roomSales;
  }

  private List<Sale> getSalesByBooking(int bookingId) {
    String sql = "SELECT * FROM sales where booking = ?";
    try {
      PreparedStatement stm = conn.prepareStatement(sql);
      stm.setInt(1, bookingId);
      ResultSet rs = stm.executeQuery();
      List<Sale> result = new ArrayList<>();
      while (rs.next()) {
        result.add(SaleMapper.Instance.map(rs));
      }
      return result;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public BookingSummary getBookingSummary(int bookingId) {
    BookingSummary summary = new BookingSummary();
    summary.booking = new BookingOperations().read(bookingId).getData();
    summary.room = new RoomOperations().read(summary.booking.getRoom()).getData();
    summary.roomSales = getSalesByBooking(bookingId);
    return summary;
  }
}
