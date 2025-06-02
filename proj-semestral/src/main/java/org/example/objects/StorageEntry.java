package org.example.objects;

public class StorageEntry extends DataObject {
  public enum EntryType {
    IN,
    OUT
  };

  private int productId;
  private EntryType entryType;
  private int amount;

  public StorageEntry() {
    super();
  }

  public StorageEntry(int productId, EntryType entryType, int amount) {
    this.productId = productId;
    this.entryType = entryType;
    this.amount = amount;
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
