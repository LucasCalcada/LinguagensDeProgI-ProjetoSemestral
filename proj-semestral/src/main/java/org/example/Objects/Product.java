package org.example.Objects;

public class Product {
  private final int id;
  private String productName;
  private int sellPrice;
  private boolean active;

  public Product(int id, String productName, int sellPrice, boolean active) {
    this.id = id;
    this.productName = productName;
    this.sellPrice = sellPrice;
    this.active = active;
  }

  public int getId() {
    return id;
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
