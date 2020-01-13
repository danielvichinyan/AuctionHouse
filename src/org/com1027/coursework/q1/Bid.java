package org.com1027.coursework.q1;

/**
 * Defines the properties and behavior of a Bid.
 *
 * @author Daniel Vichinyan
 */
public class Bid {

  private double bidValue = 0;
  private User   buyer    = null;

  /**
   * Constructor.
   * @param buyer
   * @param bidValue
   */
  public Bid(User buyer, double bidValue) {
    super();
    if (bidValue < 0 || buyer == null) {
      throw new IllegalArgumentException("Invalid Values");
    }

    this.bidValue = bidValue;
    this.buyer = buyer;

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
