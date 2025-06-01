package org.example.objects;

public class Room {
  public enum RoomStatus {
    FREE,
    OCCUPIED,
    MAINTENANCE
  }

  private String roomName;
  private int dailyRate;
  private int singleBedCount;
  private int doubleBedCount;
  private RoomStatus status;

  public Room(String roomName, int dailyRate, int singleBedCount, int doubleBedCount, RoomStatus status) {
    this.roomName = roomName;
    this.dailyRate = dailyRate;
    this.singleBedCount = singleBedCount;
    this.doubleBedCount = doubleBedCount;
    this.status = status;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public int getDailyRate() {
    return dailyRate;
  }

  public void setDailyRate(int dailyRate) {
    this.dailyRate = dailyRate;
  }

  public int getSingleBedCount() {
    return singleBedCount;
  }

  public void setSingleBedCount(int singleBedCount) {
    this.singleBedCount = singleBedCount;
  }

  public int getDoubleBedCount() {
    return doubleBedCount;
  }

  public void setDoubleBedCount(int doubleBedCount) {
    this.doubleBedCount = doubleBedCount;
  }

  public RoomStatus getStatus() {
    return status;
  }

  public void setStatus(RoomStatus status) {
    this.status = status;
  }
}
