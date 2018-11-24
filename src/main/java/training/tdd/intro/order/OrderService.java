package training.tdd.intro.order;

import com.amazon.service.AmazonBookService;
import com.amazon.service.InvalidAmazonProductAmountException;
import com.amazon.service.InvalidAmazonProductIdException;

public class OrderService {

   public boolean order(String productId, int amountOfProduct) {
      try {
         return new AmazonBookService().placeOrder(productId, amountOfProduct);
      } catch (InvalidAmazonProductIdException e) {
         System.out.println("**** Invalid order id");
      } catch (InvalidAmazonProductAmountException e) {
         System.out.println("**** Invalid amount requested");
      }
      return false;
   }

   public static void main(String[] args) {
      OrderService orderService = new OrderService();

      boolean validProduct = orderService.order("ValidProductId", 5);
      System.out.println("placing an order: " + (validProduct ? "succeeded" : "failed") + "\n");

      boolean invalidProductId = orderService.order("BadProductId", 20);
      System.out.println("placing another order: " + (invalidProductId ? "succeeded" : "failed") + "\n");

      boolean nullProductId = orderService.order(null, 10);
      System.out.println("placing order with Null product Id: " + (nullProductId ? "succeeded" : "failed") + "\n");

      boolean negativeQuantityOrder = orderService.order("ValidProductId", -1);
      System.out.println("placing order for negative # of books: " + (negativeQuantityOrder ? "succeeded" : "failed") + "\n");
   }
}
