package org.com1027.coursework.q2;

/**
 * Defines the properties and behavior of a User.
 *
 * @author Daniel Vichinyan
 */
public class User {

  private String name = null;

  /**
   * Constructor.
   * 
   * @param name
   */
  public User(String name) {
    super();
    if (name != null) {
      this.name = name;
    }
    else {
      throw new IllegalArgumentException("Input null");
    }
  }

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();
   /* if (this.name.equals("No Bids")) {
      buffer.append("***");
    }
    else {*/
      buffer.append(this.name.charAt(0));
      buffer.append("***");
      buffer.append(this.name.charAt(this.name.length() - 1));
  //  }
    return buffer.toString();
  }

}
