package training.tdd.intro.order;

import com.amazon.service.AmazonBookService;
import com.amazon.service.InvalidAmazonProductAmountException;
import com.amazon.service.InvalidAmazonProductIdException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderServiceTest {
   @Test
   public void shouldUseAmazonBookServiceToPlaceOrder() {
      MockAmazonBookService mockAmazonBookService = new MockAmazonBookService();
      OrderService orderService = new OrderService();
      orderService.setAmazonBookService(mockAmazonBookService);

      orderService.order("product", 100);

      assertTrue(mockAmazonBookService.wasCalled);
   }

   @Test
   public void shouldFailIfOrderIsForNegativeBooks() {
      AmazonBookService amazonBookService = new AmazonBookService();
      OrderService orderService = new OrderService();
      orderService.setAmazonBookService(amazonBookService);

      boolean result = orderService.order("product", -1);

      assertFalse(result);
   }

   private class MockAmazonBookService extends AmazonBookService {
      boolean wasCalled = false;

      @Override
      public boolean placeOrder(String productId, int units) throws InvalidAmazonProductIdException, InvalidAmazonProductAmountException {
         wasCalled = true;
         return true;
      }
   }
}
