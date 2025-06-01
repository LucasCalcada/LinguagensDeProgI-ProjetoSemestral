package org.example.objects;

import java.sql.Date;

public class Booking {
  private final int id;
  private int room;
  private String bookerName;
  private String bookerCpf;
  private String bookerPhone;
  private int clientCount;
  private java.sql.Date bookingStart;
  private java.sql.Date bookingEnd;

  public Booking(int id, int room, String bookerName, String bookerCpf, String bookerPhone, int clientCount,
      Date bookingStart, Date bookingEnd) {
    this.id = id;
    this.room = room;
    this.bookerName = bookerName;
    this.bookerCpf = bookerCpf;
    this.bookerPhone = bookerPhone;
    this.clientCount = clientCount;
    this.bookingStart = bookingStart;
    this.bookingEnd = bookingEnd;
  }

  public int getId() {
    return id;
  }

  public int getRoom() {
    return room;
  }

  public void setRoom(int room) {
    this.room = room;
  }

  public String getBookerName() {
    return bookerName;
  }

  public void setBookerName(String bookerName) {
    this.bookerName = bookerName;
  }

  public String getBookerCpf() {
    return bookerCpf;
  }

  public void setBookerCpf(String bookerCpf) {
    this.bookerCpf = bookerCpf;
  }

  public String getBookerPhone() {
    return bookerPhone;
  }

  public void setBookerPhone(String bookerPhone) {
    this.bookerPhone = bookerPhone;
  }

  public int getClientCount() {
    return clientCount;
  }

  public void setClientCount(int clientCount) {
    this.clientCount = clientCount;
  }

  public java.sql.Date getBookingStart() {
    return bookingStart;
  }

  public void setBookingStart(java.sql.Date bookingStart) {
    this.bookingStart = bookingStart;
  }

  public java.sql.Date getBookingEnd() {
    return bookingEnd;
  }

  public void setBookingEnd(java.sql.Date bookingEnd) {
    this.bookingEnd = bookingEnd;
  }
}
