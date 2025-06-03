package org.example.screens.table.builder;

import java.util.HashMap;
import java.util.Map;

import org.example.objects.Booking;
import org.example.objects.DataObject;
import org.example.objects.Product;
import org.example.objects.Room;
import org.example.objects.Sale;
import org.example.objects.StorageEntry;

public class DataBuilderRegistry {
  private static DataBuilderRegistry Instance;

  private final Map<Class<?>, ITableDataBuilder<?>> builderMap = new HashMap<>();

  private DataBuilderRegistry() {
    builderMap.put(Booking.class, new BookingTableBuilder());
    builderMap.put(Product.class, new ProductTableBuilder());
    builderMap.put(Room.class, new RoomTableBuilder());
    builderMap.put(Sale.class, new SaleTableBuilder());
    builderMap.put(StorageEntry.class, new StorageEntryTableBuilder());
  }

  public static DataBuilderRegistry getInstance() {
    if (Instance == null) {
      Instance = new DataBuilderRegistry();
    }
    return Instance;
  }

  public <T extends DataObject> ITableDataBuilder<T> getDataBuilder(Class<T> type) {
    return (ITableDataBuilder<T>) builderMap.get(type);
  }
}
