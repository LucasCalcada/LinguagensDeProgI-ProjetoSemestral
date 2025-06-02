package org.example.objects;

public class Product extends DataObject {
  private String productName;
  private int sellPrice;
  private boolean active;

  public Product() {
    super();
  }

  public Product(String productName, int sellPrice, boolean active) {
    this.productName = productName;
    this.sellPrice = sellPrice;
    this.active = active;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getSellPrice() {
    return sellPrice;
  }

  public void setSellPrice(int sellPrice) {
    this.sellPrice = sellPrice;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
