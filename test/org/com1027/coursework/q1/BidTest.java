package org.com1027.coursework.q1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BidTest {

  @Test
  public void testBid() {
    User user = new User("Daniel");
    Bid bid = new Bid(user, 10.00);

    assertEquals("Daniel", bid.getBuyer().toString());
    assertEquals(10.00, bid.getBidValue(), 0);
    assertEquals("Daniel bid £10.0", bid.toString());

  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidBidValue() {
    Bid bid = new Bid(null, 10.00);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidBuyer() {
    User user = new User("Daniel");
    Bid bid = new Bid(user, -10.00);
  }

}
