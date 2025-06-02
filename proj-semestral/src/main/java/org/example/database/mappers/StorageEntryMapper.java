package org.example.database.mappers;

import org.example.objects.StorageEntry;
import org.example.objects.StorageEntry.EntryType;

public class StorageEntryMapper {
  public static final DataObjectMapper<StorageEntry> Instance = rs -> {
    StorageEntry storageEntry = new StorageEntry();
    storageEntry.setProductId(rs.getInt("product"));
    storageEntry.setAmount(rs.getInt("amount"));

    EntryType entryType = EntryType.valueOf(rs.getString("status"));
    storageEntry.setEntryType(entryType);
    return storageEntry;
  };
}
