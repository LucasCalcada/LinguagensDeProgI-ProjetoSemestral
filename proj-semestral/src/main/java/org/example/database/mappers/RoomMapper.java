package org.example.database.mappers;

import org.example.objects.Room;
import org.example.objects.Room.RoomStatus;

public class RoomMapper {
  public static final DataObjectMapper<Room> Instance = rs -> {
    Room room = new Room();
    room.setRoomName(rs.getString("room_name"));
    room.setDailyRate(rs.getInt("daily_rate"));
    room.setSingleBedCount(rs.getInt("single_bed_count"));
    room.setDoubleBedCount(rs.getInt("double_bed_count"));
    room.setStatus(RoomStatus.valueOf(rs.getString("status")));
    return room;
  };
}
