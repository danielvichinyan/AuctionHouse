package org.com1027.coursework.q3;

/**
 * Defines the properties and behavior of a Bid.
 *
 * @author Daniel Vichinyan
 */
public class Bid {

  private User   buyer    = null;
  private double bidValue = 0;

  /**
   * Constructor
   * 
   * @param buyer
   * @param bidValue
   */
  public Bid(User buyer, double bidValue) {
    super();
      this.buyer = buyer;
      this.bidValue = bidValue;
  }

  public double getBidValue() {
    return this.bidValue;
  }

  public User getBuyer() {
    return this.buyer;
  }

  /**
   * toString method
   * Returns the bid in the following format:
   * @return buyerName bid J0
   */
  @Override
  public String toString() {
    return this.buyer.toString() + " bid £" + this.bidValue;
  }

}
