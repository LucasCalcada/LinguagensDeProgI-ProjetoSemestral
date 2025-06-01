package org.example.Objects;

public class StorageEntry {
  public enum EntryType {
    IN,
    OUT
  };

  private final int id;
  private int productId;
  private EntryType entryType;
  private int amount;

  public StorageEntry(int id, int productId, EntryType entryType, int amount) {
    this.id = id;
    this.productId = productId;
    this.entryType = entryType;
    this.amount = amount;
  }

  public int getId() {
    return id;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public EntryType getEntryType() {
    return entryType;
  }

  public void setEntryType(EntryType entryType) {
    this.entryType = entryType;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
