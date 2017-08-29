package com.amazon.service;

import java.util.Arrays;
import java.util.List;

public class AmazonBookService {

    List<String> productIdCatalog = Arrays.asList("Foo", "Baz", "Zot");

   public boolean placeOrder(String productId, int units) throws InvalidAmazonProductIdException, InvalidAmazonProductAmountException {
      System.out.println("calling Amazon Book Service for " + units + " units of " + productId);
      simulateLongNetworkLatencyDelay();
      if (productId == null || ! productIdCatalog.contains(productId))
         throw new InvalidAmazonProductIdException("Invalid product id: " + productId);
      if (units < 0)
         throw new InvalidAmazonProductAmountException("Product amount cannot be negative - " + units);

      return hasSufficientInventory(productId, units);
   }

    private static void simulateLongNetworkLatencyDelay() {
      try {
         Thread.sleep(10000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

    private boolean hasSufficientInventory(String productId, int units) {
        return units < 10;
    }
}
