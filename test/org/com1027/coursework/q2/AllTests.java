/**
 * AllTests.java
 */

package org.com1027.coursework.q2;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Daniel Vichinyan
 */
@RunWith(Suite.class)
@SuiteClasses({ AuctionHouseTest.class,  UserTest.class, BiddableProductTest.class, BuyNowProductTest.class})
public class AllTests {
}
