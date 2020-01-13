package org.com1027.coursework.q1;

import java.util.ArrayList;
import java.util.List;
/**
 * Defines the properties and behavior of a product.
 *
 * @author Daniel Vichinyan
 */
public class Product {

  private int       productID     = 0;
  private String    productName   = null;
  private double    reservedPrice = 0;
  private List<Bid> bids          = null;

  /**
   * Constructor.
   * 
   * @param id
   * @param name
   * @param price
   */
  public Product(int id, String name, double price) {
    super();
    if (id < 0 || name == null || price < 0) {
      throw new IllegalArgumentException("Invalid Input has been entered");
    }
    this.productID = id;
    this.productName = name;
    this.reservedPrice = price;
    this.bids = new ArrayList<Bid>();

  }

  public int getProductId() {
    return this.productID;
  }

  public String getProductName() {
    return this.productName;
  }

  public double getReservedPrice() {
    return this.reservedPrice;
  }

  /**
   * Returns the highest bid.
   * @return the highest bid.
   */
  public Bid getHighestBid() {
    Bid highestBid = null;
    if (this.bids.size() > 0) {
      highestBid = this.bids.get(this.bids.size() - 1);
    }
    return highestBid;
  }

  /**
   * Places a bid.
   * 
   * @param user
   * @param bidValue
   * 
   * If the user is not null and the bid value is above 0
   * @return true
   * 
   * If the highest bid is null or the new bid value is greater than the current value
   * @return false
   */
  public boolean placeBid(User user, double bidValue) {
    if (user != null && bidValue > 0) {
      boolean result = false;
      if (this.getHighestBid() == null || bidValue > this.getHighestBid().getBidValue()) {
        this.bids.add(new Bid(user, bidValue));
        result = true;
      }
      return result;
    }
    else {
      throw new IllegalArgumentException("not valid arguments for placeBid");
    }
  }

}
