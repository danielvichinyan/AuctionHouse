
package org.com1027.coursework.q2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Tests for the BuyNow class.
 * 
 * @author Daniel Vichinyan
 */
public class BuyNowProductTest {
  
  
  /**
   * Creating a BiddableProduct object with valid input parameter for the product. 
   * Test that initial values of getters can be retrieved correctly. 
   * 
   * 
   */
 @Test
 public void testProductConstruction() {
   BuyNowProduct product = new BuyNowProduct(1,"ball",10.00,5);
   assertEquals(1, product.getProductId());
   assertEquals("ball", product.getProductName());
   assertEquals(10.0, product.getCurrentPrice(),0);
   assertFalse(product.isProductSold());   
   //System.out.println(product.displayHistory());
   assertEquals("1: ball quantity: 5\n"+"no purchases", product.displayHistory());
   //System.out.println(product.displayUserInfoForProduct());
   assertEquals("", product.displayUserInfoForProduct());
  
 }
 

 /**
  * Creating a BuyNow object with invalid input parameter for the user. 
  * 
  */
 @Test(expected=IllegalArgumentException.class)
 public void testProductInvalidConstruction1() {
   BuyNowProduct product = new BuyNowProduct(1,null,10.00,5);
 }

 /**
  * Creating a BuyNow object with invalid input parameter for the price. 
 * 
  */
 @Test(expected=IllegalArgumentException.class)
 public void testProductInvalidConstruction2() {
   BuyNowProduct product = new BuyNowProduct(1,"ball",0.00,5);
 }
 
 
 /**
  * Creating a BuyNow object with invalid input parameter for the quantity. 
 * 
  */
 @Test(expected=IllegalArgumentException.class)
 public void testProductInvalidConstruction3() {
   BuyNowProduct product = new BuyNowProduct(1,"ball",10.00,0);
 }
 /**
  * Creating a BuyNow object with valid input parameters for the product. 
  * Test purchases can be made and displays work
  * 
  * System.out can be used during debugging of code
  * 
  */
 @Test
 public void testAttemptToPurchaseAndQueryAndDisplayPurchases() {
   BuyNowProduct product1 = new BuyNowProduct(1,"ball",10.00,9);
   User user1 = new User("Daniel");
   User user2 = new User("Milen");
   // no bid initially placed for the ball so display product will be empty string
   //System.out.println(product1.displayUserInfoForProduct());
   assertEquals("",product1.displayUserInfoForProduct());   
   //System.out.println(product1.displayHistory());
   assertEquals("1: ball quantity: 9\n"+"no purchases", product1.displayHistory());
      
   //Daniel buys 5 ball
   assertEquals(true, product1.attemptToPurchase(user1, 5));
   //check that the display methods are as intended
   //System.out.println(product1.displayUserInfoForProduct());
   assertEquals("D***l bought 5",product1.displayUserInfoForProduct());
   //System.out.println(product1.displayHistory());
   assertEquals("1: ball quantity: 9\n"+"buy now history: \n" + "D***l bought 5\n", 
       product1.displayHistory());
    
   //Milen buys 2
   assertEquals(true, product1.attemptToPurchase(user2, 2));
   assertEquals("M***n bought 2",product1.displayUserInfoForProduct());
   //System.out.println(product1.displayHistory());
   assertEquals("1: ball quantity: 9\n"+"buy now history: \n" + "D***l bought 5\n" + "M***n bought 2\n",  
       product1.displayHistory());
 }
 
 /**
  * Creating a BuyNow object with valid input parameter for the product. 
  * Test purchases can be made when there are buy now items available 
  * and that is product sold demonstrates all quantity sold
  * 
  * 
  */
 
 @Test
 public void testAttemptToPurchaseAndIsSold() {
   BuyNowProduct product1 = new BuyNowProduct(1,"ball",10.00,10);
   User user1 = new User("Daniel");
   User user2 = new User("Milen");
   
   //Daniel buys 5 ball
   assertEquals(true, product1.attemptToPurchase(user1, 5));
   assertFalse(product1.isProductSold());
  
   //Milen buys 2 ball
   assertEquals(true, product1.attemptToPurchase(user2, 2));
   assertFalse(product1.isProductSold());
   
   //Daniel buys another 3
   assertEquals(true, product1.attemptToPurchase(user1, 3));
   assertTrue(product1.isProductSold());

   //Daniel attempts to buys another 3
   assertEquals(false, product1.attemptToPurchase(user1, 3));
 
 }
 
}