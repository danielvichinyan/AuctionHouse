package org.com1027.coursework.q3;

import java.util.ArrayList;
import java.util.List;

public class BiddableProduct extends Product {

  private double    reservedPrice = 0;   // product must have a >0
  private List<Bid> bids          = null; // records the list of bids for this product

  public BiddableProduct(int productId, String productName, double reservedPrice) {
    super(productId, productName);
      this.reservedPrice = reservedPrice;
      this.bids = new ArrayList<Bid>();
   }

  /**
   * bid are stored as the highest value being last, so need to check the last
   * 
   * @param bid
   */
  // @Override
  public boolean attemptToPurchase(User user, double bidValue) {
    // check arguments
    if (user != null && bidValue > 0) {
      boolean result = false;
      double currentPrice = this.getCurrentPrice();
      // if 0 then no bids.
      if (currentPrice == 0) {
        this.bids.add(new Bid(user, bidValue));
        result = true;
      }
      else {
        // now there are bids and we need to check that bidValue is sensible
        if (this.getCurrentPrice() < bidValue) {
          // set a new highest bid
          this.bids.add(new Bid(user, bidValue));
          result = true;
        }
      }
      return result;
    }
    else {
      throw new IllegalArgumentException("not valid arguments");
    }
  }

  // as stella had
  @Override
  public String displayHistory() {
    StringBuffer buffer = new StringBuffer("");
    buffer.append(this.getProductId() + ": " + this.getProductName() + " = ");
    if (this.bids.size() == 0) {
      buffer.append("no bids");
    }
    else {
      buffer.append("\n");
      for (int i = this.bids.size() - 1; i >= 0; i--) {
        buffer.append(this.bids.get(i).toString() + "\n");
      }
    }
    return buffer.toString();

  }

  /**
   * This is an implementation of displayProduct which returns the information about the highestbid by calling the toString from the
   * Bid class
   */
  @Override
  public String displayUserInfoForProduct() {
    String result = "";
    if (this.bids.size() > 0) {
      result = this.bids.get(this.bids.size() - 1).toString();
    }
    return result;
  }

  /**
   * 
   * @return null if no bid to return
   */
  @Override
  public double getCurrentPrice() {
    double currentPrice = 0;
    if (this.bids.size() > 0) {
      Bid highestBid = this.bids.get(this.bids.size() - 1);
      currentPrice = highestBid.getBidValue();
    }
    return currentPrice;
  }

  public double getReservedPrice() {
    return this.reservedPrice;
  }

  /**
   * check if product met reserve price
   */
  @Override
  public boolean isProductSold() {
    boolean result = false;
    if (this.getCurrentPrice() >= this.getReservedPrice()) {
      result = true;
    }
    return result;
  }
  
  public User getBuyer(){
    User user = null;
    if (this.bids.size() > 0) {
      Bid highestBid = this.bids.get(this.bids.size() - 1);
      user = highestBid.getBuyer();
    }
    return user;
  }   
  
}
