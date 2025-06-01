package org.example.Objects;

public class Sale {
  private final int id;
  private int productId;
  private int amount;
  private int price;
  private int bookingId;

  public Sale(int id, int productId, int amount, int price, int bookingId) {
    this.id = id;
    this.productId = productId;
    this.amount = amount;
    this.price = price;
    this.bookingId = bookingId;
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

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
  }
}
