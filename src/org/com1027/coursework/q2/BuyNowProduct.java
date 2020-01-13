package org.com1027.coursework.q2;

import java.util.ArrayList;
import java.util.List;

public class BuyNowProduct extends Product {

  private double         price     = 0;
  private int            quantity  = 0;
  private List<Purchase> purchases = null;

  public BuyNowProduct(int productId, String productName, double price, int quantity) {
    super(productId, productName);
    if (price > 0 && quantity > 0) {
      this.price = price;
      this.quantity = quantity;
      this.purchases = new ArrayList<Purchase>();
    }
    else {
      throw new IllegalArgumentException("invalid price or quantity");
    }
  }

  public boolean attemptToPurchase(User user, int quantity) {
    if (user != null && quantity > 0) {
      boolean result = false;
      if (quantity <= (this.quantity - this.howManyPurchases())) {
        this.purchases.add(new Purchase(user, quantity));
        result = true;
      }
      return result;
    }
    else {
      throw new IllegalArgumentException("not valid arguments");
    }
  }

  @Override
  public String displayHistory() {
    StringBuffer buffer = new StringBuffer("");
    buffer.append(this.getProductId());
    buffer.append(": ");
    buffer.append(this.getProductName());
    buffer.append(" ");
    buffer.append("quantity: ");
    buffer.append(this.getQuantity());
    buffer.append("\n");
    if (this.purchases.size() == 0) {
      buffer.append("no purchases");
    }
    else {
      buffer.append("buy now history: \n");
      for (Purchase purchase : this.purchases) {
        buffer.append(purchase.toString() + "\n");
      }
    }
    return buffer.toString();
  }

  @Override
  public String displayUserInfoForProduct() {
    String result = "";
    if (this.purchases.size() > 0) {
      result = this.purchases.get(this.purchases.size() - 1).toString();
    }
    return result;
  }

  @Override
  public double getCurrentPrice() {
    return this.price;
  }

  public int getQuantity() {
    return this.quantity;
  }

  private int howManyPurchases() {
    int total = 0;
    for (Purchase purchase : this.purchases) {
      total += purchase.getQuantityPurchased();
    }
    return total;
  }

  @Override
  public boolean isProductSold() {
    boolean result = false;
    if (this.quantity == this.howManyPurchases()) {
      result = true;
    }
    return result;
  }
}
