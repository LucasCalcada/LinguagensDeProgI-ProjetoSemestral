package org.example.database.mappers;

import org.example.objects.Booking;

public class BookingMapper {
  public static final DataObjectMapper<Booking> Instance = rs -> {
    Booking booking = new Booking();
    booking.setRoom(rs.getInt("room"));
    booking.setBookerName(rs.getString("booker_name"));
    booking.setBookerCpf(rs.getString("booker_cpf"));
    booking.setBookerPhone(rs.getString("booker_phone"));
    booking.setClientCount(rs.getInt("client_count"));
    booking.setBookingStart(rs.getDate("booking_start"));
    booking.setBookingEnd(rs.getDate("booking_end"));
    return booking;
  };
}
