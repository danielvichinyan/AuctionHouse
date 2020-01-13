
package org.com1027.coursework.q3;

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
    assertEquals("M***n", user.toString());
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

  @Test
  public void testDisplayAllPurchases() {
    AuctionHouse auction = new AuctionHouse();

    BiddableProduct teddy = new BiddableProduct(1, "teddy", 10.00);
    BiddableProduct doll = new BiddableProduct(2, "doll", 5.00);

    BuyNowProduct car = new BuyNowProduct(3, "car", 12.00, 1);
    BuyNowProduct ball = new BuyNowProduct(4, "ball", 2.00, 5);

    User user1 = new User("Daniel");
    User user2 = new User("Milen");

    auction.register(teddy, user1);
    auction.register(doll, user1);
    auction.register(car, user1);
    auction.register(ball, user1);

    auction.placeBid(teddy, user2, 10.00);
    auction.placeBid(teddy, user1, 11.00);
    auction.placeBid(teddy, user2, 12.00);

    auction.placeBid(doll, user2, 7.50);

    auction.buyNow(car, user2, 1);

    auction.buyNow(ball, user2, 4);

    auction.endAuction(teddy);
    auction.endAuction(doll);

    assertEquals("All Purchased Products: \n" + 
        "Purchases: \n" + 
        "Successful Bids: \n",user1.displayAllPurchases());
    
    assertEquals("All Purchased Products: \n" + 
        "Purchases: \n" + 
        "3 with quantity 1\n" + 
        "4 with quantity 4\n" + 
        "Successful Bids: \n" + 
        "1 at a cost of 12.0\n" + 
        "2 at a cost of 7.5\n",user2.displayAllPurchases());

  }

  @Test
  public void testDisplayPurchases() {
    AuctionHouse auction = new AuctionHouse();

    BuyNowProduct car = new BuyNowProduct(3, "car", 12.00, 1);
    BuyNowProduct ball = new BuyNowProduct(4, "ball", 2.00, 5);

    User user1 = new User("Daniel");
    User user2 = new User("Milen");

  
    auction.register(car, user1);
    auction.register(ball, user1);

   
    auction.buyNow(car, user2, 1);

    auction.buyNow(ball, user2, 1);

    assertEquals("Purchases: \n" + 
        "3 with quantity 1\n" + 
        "4 with quantity 1\n" ,user2.displayPurchases());
  }

  @Test
  public void testDisplaySuccessfulBids() {
    AuctionHouse auction = new AuctionHouse();

    BiddableProduct teddy = new BiddableProduct(1, "teddy", 10.00);
    BiddableProduct doll = new BiddableProduct(2, "doll", 5.00);

    User user1 = new User("Daniel");
    User user2 = new User("Milen");

    auction.register(teddy, user1);
    auction.register(doll, user1);


    auction.placeBid(teddy, user2, 10.00);
    auction.placeBid(teddy, user1, 11.00);
    auction.placeBid(teddy, user2, 12.00);
    auction.placeBid(teddy, user1, 15.00);
    auction.placeBid(teddy, user2, 20.00);

    auction.placeBid(doll, user2, 7.50);

    auction.endAuction(teddy);
    auction.endAuction(doll);

  
    assertEquals("Successful Bids: \n" + 
        "1 at a cost of 20.0\n" + 
        "2 at a cost of 7.5\n",user2.displaySuccessfulBids());
  }
}