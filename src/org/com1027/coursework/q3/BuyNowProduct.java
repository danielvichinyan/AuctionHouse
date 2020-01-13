package org.com1027.coursework.q3;

import java.util.ArrayList;
import java.util.List;
/**
 * Defines the properties and behavior of a buy now product
 *
 * @author Daniel Vichinyan
 */
public class BuyNowProduct extends Product {

  private double         price     = 0;   // product must be sold for this price
  private int            quantity  = 0;
  private List<Purchase> purchases = null; // records the list of purchases for this product

  /**
   * Constructor.
   * 
   * @param productId
   * @param productName
   * @param price
   * @param quantity
   */
  public BuyNowProduct(int productId, String productName, double price, int quantity) {
    super(productId, productName);
    if (price > 0 && quantity > 0) {
      this.price = price;
      this.quantity = quantity; // initial total quantity
      this.purchases = new ArrayList<Purchase>();
    }
    else {
      throw new IllegalArgumentException("invalid price or quantity");
    }
  }

  /**
   * bid are stored as the highest value being last, so need to check the last
   * 
   * @param bid
   */
  public boolean attemptToPurchase(User user, int quantity) {
    // check arguments
    if (user != null && quantity > 0) {
      boolean result = false;
      if (quantity <= (this.quantity-this.howManyPurchases())) {
        this.purchases.add(new Purchase(user, quantity));
        result = true;
      }
      // returns false if quantity not ok
      return result;
    }
    else {
      throw new IllegalArgumentException("not valid arguments");
    }
  }

  /**
   * Displays buy now history
   */
  @Override
  public String displayHistory() {
    StringBuffer buffer = new StringBuffer("");
    buffer.append(this.getProductId() + ": ");
    buffer.append(this.getProductName() + " ");
    buffer.append("quantity: ");
    buffer.append(this.getQuantity());
    buffer.append("\n");
    if (this.purchases.size() == 0) {
      buffer.append("no purchases");
    }
    else {
      buffer.append("buy now history: \n");
      for (Purchase p : this.purchases) {
        buffer.append(p.toString() + "\n");
      }
    }
    return buffer.toString();
  }

  /**
   * Displays info for product
   */
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

  /**
   * Counts the purchases of a product
   * @return total number of purchases
   */
  private int howManyPurchases() {
    int total = 0;
    for (Purchase p : this.purchases) {
      total += p.getQuantityPurchased();
    }
    return total;
  }

  /**
   * Check if product sold all its quantity.
   */
  @Override
  public boolean isProductSold() {
    boolean result = false;
    if (this.quantity == this.howManyPurchases()) {
      result = true;
    }
    return result;
  }
 
  /**
   * Takes the latest buyer of a product.
   * @return the latest buyer
   */
  public User getBuyer(){
    User user = null;
    if (this.purchases.size() > 0) {
      Purchase latestBuyer = this.purchases.get(this.purchases.size() - 1);
      user = latestBuyer.getBuyer();
    }
    return user;
  }  
}
