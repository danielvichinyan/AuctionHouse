package org.com1027.coursework.q2;

/**
 * Abstract class. Defines the general behaviour of a product.
 *
 * @author Daniel Vichinyan
 */
public abstract class Product {

  private int    productId   = 0;
  private String productName = null;

  /**
   * Constructor.
   * 
   * @param id
   * @param name
   */
  public Product(int productId, String productName) {
    super();
    if (productName != null && productId > 0) {
      this.productId = productId;
      this.productName = productName;
    }
    else {
      throw new IllegalArgumentException("invalid name");
    }
  }

  public abstract String displayHistory();

  public abstract String displayUserInfoForProduct();

  public abstract double getCurrentPrice();

  public int getProductId() {
    return this.productId;
  }

  public String getProductName() {
    return this.productName;
  }

  public abstract boolean isProductSold();
  
  /**
   * toString method
   * Returns a string in the following format:
   * @return productID - productName
   */
  @Override
  public String toString() {
    return this.getProductId() + " - " + this.getProductName();
  }

}
