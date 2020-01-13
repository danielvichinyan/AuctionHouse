package org.com1027.coursework.q2;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the properties and behavior of a biddable product
 *
 * @author Daniel Vichinyan
 */
public class BiddableProduct extends Product {

  private double    reservedPrice = 0;
  private List<Bid> bids          = null;

  /**
   * Constructor.
   * 
   * @param productId
   * @param productName
   * @param reservedPrice
   */
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
  public boolean attemptToPurchase(User user, double bidValue) {
    // check arguments
    if (user != null && bidValue > 0) {
      boolean result = false;
      if (this.getCurrentPrice() == 0 || this.getCurrentPrice() < bidValue) {
        this.bids.add(new Bid(user, bidValue));
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
    buffer.append(this.getProductId());
    buffer.append(": ");
    buffer.append(this.getProductName());
    buffer.append(" = ");
    if (this.bids.size() == 0) {
      buffer.append("no bids");
    }
    else {
      buffer.append("\n");
      for (int i = this.bids.size() - 1; i >= 0; i--) {
        buffer.append(this.bids.get(i).toString());
        buffer.append("\n");
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
    if (this.bids.size() > 0) {
      result = this.bids.get(this.bids.size() - 1).toString();
    }
    return result;
  }

  @Override
  public double getCurrentPrice() {
    double currentPrice = 0;
    if (this.bids.size() > 0) {
      currentPrice = this.bids.get(this.bids.size() - 1).getBidValue();
    }
    return currentPrice;
  }

  public double getReservedPrice() {
    return this.reservedPrice;
  }

  @Override
  public boolean isProductSold() {
    boolean result = false;
    if (this.getCurrentPrice() >= this.getReservedPrice()) {
      result = true;
    }
    return result;
  }
}
