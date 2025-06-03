package org.example.screens.table.builder;

import org.example.database.entities.DbEntity;
import org.example.objects.Room;

public class RoomTableBuilder implements ITableDataBuilder<Room> {
  @Override
  public String[] dataObjectHeaders() {
    return new String[] {
        "Id", "Nome", "Diária", "Camas Solteiro", "Camas Casal", "Status"
    };
  }

  @Override
  public String[] dataObjectToRow(DbEntity<Room> obj) {
    String id = Integer.toString(obj.getId());

    Room dataObj = obj.getData();
    String roomName = dataObj.getRoomName();
    String dailyRate = Integer.toString(dataObj.getDailyRate());
    String singleBeds = Integer.toString(dataObj.getSingleBedCount());
    String doubleBeds = Integer.toString(dataObj.getDoubleBedCount());
    String status = dataObj.getStatus().toString();

    return new String[] {
        id, roomName, dailyRate, singleBeds, doubleBeds, status
    };
  }
}
