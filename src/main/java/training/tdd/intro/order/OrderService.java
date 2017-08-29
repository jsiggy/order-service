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

      System.out.println("placing an order: " + (orderService.order("Foo", 5) ? "succeeded" : "failed"));
      System.out.println("placing another order: " + (orderService.order("Bar", 20) ? "succeeded" : "failed"));
      System.out.println("placing order with null product Id: " + (orderService.order(null, 10) ? "succeeded" : "failed"));
      System.out.println("placing order for negative # of books: " + (orderService.order("Baz", -1) ? "succeeded" : "failed"));
   }
}
