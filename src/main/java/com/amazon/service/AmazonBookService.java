package com.amazon.service;

public class AmazonBookService {

   public boolean placeOrder(String productId, int units) throws InvalidAmazonProductIdException, InvalidAmazonProductAmountException {
      System.out.println("calling Amazon Book Service for " + units + " units of " + productId);
      networkLatencyDelay();
      if (productId == null || productId.length() < 5)
         throw new InvalidAmazonProductIdException("Invalid product id: " + productId);
      if (units < 0)
         throw new InvalidAmazonProductAmountException("Product amount cannot be negative - " + units);

      return units < 10;
   }

   private static void networkLatencyDelay() {
      try {
         Thread.sleep(10000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
