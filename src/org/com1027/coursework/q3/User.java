package org.com1027.coursework.q3;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines the properties and behavior of a User.
 *
 * @author Daniel Vichinyan
 */
public class User {

  private String                name           = null;
  // storing productId
  private Map<Integer, Integer> purchases      = null;
  private Map<Integer, Double>  successfulBids = null;

  /**
   * Constructor.
   * 
   * @param name
   */
  public User(String name) {
    super();
    if (name != null) {
      this.name = name;
      this.purchases = new HashMap<Integer, Integer>();
      this.successfulBids = new HashMap<Integer, Double>();
    }
    else {
      throw new IllegalArgumentException("Input is null");
    }

  }

  /**
   * Buys a product with a particular quantity.
   * 
   * @param productId
   * @param quantity
   */
  public void buy(int productId, int quantity) {
    if (purchases.containsKey(productId)) {
      int tempQuantity = purchases.get(productId);
      purchases.put(productId, tempQuantity + quantity);
    }
    else {
      purchases.put(productId, quantity);

    }

  }

  public void wonAuction(int productId, double winningPrice) {
    this.successfulBids.put(productId, winningPrice);
  }

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();

    buffer.append(this.name.charAt(0));
    buffer.append("***");
    buffer.append(this.name.charAt(this.name.length() - 1));

    return buffer.toString();
  }

  /**
   * Displays all purchases.
   * 
   * @return a string in the format:
   * Purchases: 
   * 1223 with quantity 1
   */
  public String displayPurchases() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("Purchases: \n");
    for (Map.Entry<Integer, Integer> entry : purchases.entrySet()) {
      buffer.append(entry.getKey() + " with quantity " + entry.getValue() + "\n");
    }
    return buffer.toString();
  }

  public String displaySuccessfulBids() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("Successful Bids: \n");
    for (Map.Entry<Integer, Double> entry : successfulBids.entrySet()) {
      buffer.append(entry.getKey() + " at a cost of " + entry.getValue() + "\n");
    }
    return buffer.toString();
  }

  /**
   * Displays all purchased products.
   * 
   * @return a string of all purchased products in the format:
   * All Purchased Products:
   * Purchases: 
   * 1223 with quantity 1
   */
  public String displayAllPurchases() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("All Purchased Products: \n");
    buffer.append(displayPurchases());
    buffer.append(displaySuccessfulBids());
    return buffer.toString();
  }

}
