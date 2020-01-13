package org.com1027.coursework.q1;

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
    if (name == null) {
      throw new IllegalArgumentException("Value cannot be null");
    }
    else {
      this.name = name;
    }
  }

  @Override
  public String toString() {
    return this.name;
  }
}
