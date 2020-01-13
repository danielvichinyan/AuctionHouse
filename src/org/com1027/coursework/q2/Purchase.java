package org.com1027.coursework.q2;
/**
 * Defines the properties and behavior of a purchase
 *
 * @author Daniel Vichinyan
 */
public class Purchase {

  private User buyer             = null;
  private int  quantityPurchased = 0;

  /**
   * Constructor.
   * @param buyer
   * @param quantityPurchased
   */
  public Purchase(User buyer, int quantityPurchased) {
    super();
    this.buyer = buyer;
    this.quantityPurchased = quantityPurchased;
  }

  public User getBuyer() {
    return this.buyer;
  }

  public double getQuantityPurchased() {
    return this.quantityPurchased;
  }

  /**
   * @return a string in the format:
   * buyerName bought quantityPurchased
   */
  @Override
  public String toString() {
    return this.buyer.toString() + " bought " + this.quantityPurchased;
  }

}
