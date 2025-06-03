package org.example.screens.table.builder;

import org.example.database.entities.DbEntity;
import org.example.objects.Booking;

public class BookingTableBuilder implements ITableDataBuilder<Booking> {
  @Override
  public String[] dataObjectHeaders() {
    return new String[] {
        "Id", "Id Quarto", "Hóspede", "CPF", "Telefone", "Nº Clientes", "Início Estadia", "Fim Estaida"
    };
  }

  @Override
  public String[] dataObjectToRow(DbEntity<Booking> obj) {
    String id = Integer.toString(obj.getId());

    Booking dataObj = obj.getData();
    String roomId = Integer.toString(dataObj.getRoom());
    String booker = dataObj.getBookerName();
    String cpf = dataObj.getBookerCpf();
    String phone = dataObj.getBookerPhone();
    String clientCount = Integer.toString(dataObj.getClientCount());
    String startDate = dataObj.getBookingStart().toString();
    String endDate = dataObj.getBookingEnd().toString();

    return new String[] {
        id, roomId, booker, cpf, phone, clientCount, startDate, endDate
    };
  }
}
