
package org.com1027.coursework.q1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for the User class.
 * 
 * @author Daniel Vichinyan
 */
public class UserTest {

  /**
   * Creating a User object with valid input parameter for the user. Test that the toString() can be retrieved correctly.
   * 
   * 
   */
  @Test
  public void testUserConstruction() {
    User user = new User("Milen");
    assertEquals("Milen", user.toString());
  }

  /**
   * Creating a User object with invalid input parameter for the user. Test that the exception thrown.
   * 
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUserInvalidConstructions() {
    User user = new User(null);
  }
}