package training.tdd.intro.order;

import com.amazon.service.AmazonBookService;
import com.amazon.service.InvalidAmazonProductAmountException;
import com.amazon.service.InvalidAmazonProductIdException;

public class MyAmazonBookService implements BookService {

   private AmazonBookService bookService;

   public boolean purchase(String productId, int amountOfProduct) {
      try {
         return bookService.placeOrder(productId, amountOfProduct);
      } catch (InvalidAmazonProductIdException e) {
         System.out.println("**** Invalid order id");
         throw new UnknownProductIdException(productId);
      } catch (InvalidAmazonProductAmountException e) {
         System.out.println("**** Invalid amount requested");
      }
      return false;
   }

   public static void main(String[] args) {
      MyAmazonBookService myAmazonBookService = new MyAmazonBookService();
      System.out.println("blah1 order " + (myAmazonBookService.purchase("blah1", 5) ? "succeeded" : "failed"));
      System.out.println("blah2 order " + (myAmazonBookService.purchase("blah2", 20) ? "succeeded" : "failed"));
      System.out.println("null order " + (myAmazonBookService.purchase(null, 10) ? "succeeded" : "failed"));
      System.out.println("negative order " + (myAmazonBookService.purchase("blah1", -1) ? "succeeded" : "failed"));
   }

   public void setAmazonBookService(AmazonBookService bookService) {
      this.bookService = bookService;
   }
}
