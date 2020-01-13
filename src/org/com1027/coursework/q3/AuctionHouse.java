package org.com1027.coursework.q3;

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
  public boolean buyNow(BuyNowProduct product, User buyer, int quantity) {
    if (product == null || buyer == null || quantity == 0) {
      throw new IllegalArgumentException("place bid parameter not valid");
    }

    boolean result = false;
    if (this.checkExistence(product) && product.attemptToPurchase(buyer, quantity)) {
      this.soldProducts.put(product, buyer);
      buyer.buy(product.getProductId(), quantity);
      result = true;
    }

    return result;

  }

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
    for (Product product : this.soldProducts.keySet()) {
      buffer.append(product.getProductId());
      buffer.append(" - ");
      buffer.append(product.displayUserInfoForProduct() + "\n");
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
    for (Product product : this.unsoldProducts.keySet()) {
      buffer.append(product.getProductId());
      buffer.append(" - ");
      buffer.append(product.getProductName() + "\n");
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
    if (this.checkExistence(product)) {
      if (product.isProductSold()) {
        product.getBuyer().wonAuction(product.getProductId(), product.getCurrentPrice());
        this.soldProducts.put(product, this.forSaleProducts.get(product));
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
  public boolean placeBid(BiddableProduct product, User buyer, double value) {
    if (product == null || buyer == null || value == 0) {
      throw new IllegalArgumentException("place bid parameter not valid");
    }
    boolean result = false;
    if (this.checkExistence(product)) {
      if (product.attemptToPurchase(buyer, value)) {
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
