package org.com1027.coursework.q1;

import java.util.HashMap;
import java.util.Map;
/**
 * Defines the properties and behavior of an action house
 *
 * @author Daniel Vichinyan
 */
public class AuctionHouse {

  private Map<Product, User> forSaleProducts = null;
  private Map<Product, User> soldProducts    = null;
  private Map<Product, User> unsoldProducts  = null;

  /**
   * Constructor.
   */
  public AuctionHouse() {
    super();
    this.forSaleProducts = new HashMap<Product, User>();
    this.soldProducts = new HashMap<Product, User>();
    this.unsoldProducts = new HashMap<Product, User>();
  }

  /**
   * Method to buy product.
   * @param product
   * @param buyer
   * @param quantity
   * 
   * @return true 
   */
  public boolean buyNow(Product product, User buyer, int quantity) { return true;}

  /**
   * @param product
   * 
   * If the product is in the HashMap (it exists)
   * @return true
   * 
   * If the product is not existent in the HashMap
   * @return false
   */
  public boolean checkExistence(Product product) {
    boolean exist = false;
    if (forSaleProducts.containsKey(product)) {
      exist = true;
    }
    return exist;
  }

  /**
   * Displays the sold products in the following format.
   * productId - highestBid
   * 
   * @return the buffer as a string
   */
  public String displaySoldProducts() {
    StringBuffer buffer = new StringBuffer();
    for (Product soldProduct : this.soldProducts.keySet()) {
      buffer.append(soldProduct.getProductId());
      buffer.append(" - ");
      buffer.append(soldProduct.getHighestBid().toString());
      buffer.append("\n");
    }
    return buffer.toString();
  }

  /**
   * Displays the unsold products in the following format.
   * productId - ProductName
   * 
   * @return the buffer as a string
   */
  public String displayUnsoldProducts() {
    StringBuffer buffer = new StringBuffer();
    for (Product unsoldProduct : this.unsoldProducts.keySet()) {
      buffer.append(unsoldProduct.getProductId());
      buffer.append(" - ");
      buffer.append(unsoldProduct.getProductName());
      buffer.append("\n");
    }
    return buffer.toString();
  }

  /**
   * Ends auction for particular product.
   * @param product
   */
  public void endAuction(Product product) {
    if (product == null) {
      throw new IllegalArgumentException("null product");
    }
    if (checkExistence(product)) {
      if (product.getHighestBid() != null && product.getHighestBid().getBidValue() >= product.getReservedPrice()) {
        this.soldProducts.put(product, product.getHighestBid().getBuyer());
      }
      else {
        this.unsoldProducts.put(product, this.forSaleProducts.get(product));
      }
      this.forSaleProducts.remove(product);
    }
  }

  /**
   * Places a bid for a product.
   * @param product
   * @param user
   * @param bidValue
   * 
   * If the product exists, place bid
   * @return true
   * 
   * Otherwise,
   * @return false
   */
  public boolean placeBid(Product product, User user, double bidValue) {
    if (product == null || user == null || bidValue == 0) {
      throw new IllegalArgumentException("place bid parameter not valid");
    }

    boolean result = false;
    if (checkExistence(product)) {
      if (product.placeBid(user, bidValue)) {
        result = true;
      }
    }
    return result;

  }
  
  /**
   * Registers a product.
   * @param product
   * @param user
   * 
   * 
   * @return
   */
  public boolean register(Product product, User user) {
    boolean result = false;
    if (product == null || user == null) {
      throw new IllegalArgumentException("arugments are not valid");
    }
    if (this.forSaleProducts.isEmpty() || !this.checkExistence(product)) {
      this.forSaleProducts.put(product, user);
      result = true;
    }

    return result;
  }

}
