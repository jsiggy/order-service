package training.tdd.intro.order;

import com.amazon.service.AmazonBookService;
import com.amazon.service.InvalidAmazonProductAmountException;
import com.amazon.service.InvalidAmazonProductIdException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyAmazonBookServiceTest {

   public static final int AVAILABLE_INVENTORY = 100;

   @Mock
   private AmazonBookService mockAmazonBookService;

   @Test
   public void shouldUseAmazonBookServiceToPlaceOrder() throws InvalidAmazonProductAmountException, InvalidAmazonProductIdException {
      MyAmazonBookService myAmazonBookService = new MyAmazonBookService();
      myAmazonBookService.setAmazonBookService(mockAmazonBookService);

      myAmazonBookService.purchase("product", AVAILABLE_INVENTORY);

      verify(mockAmazonBookService).placeOrder("product", AVAILABLE_INVENTORY);
   }

   @Test
   public void shouldFailIfOrderIsForNegativeBooks() throws InvalidAmazonProductAmountException, InvalidAmazonProductIdException {
      when(mockAmazonBookService.placeOrder(anyString(), eq(-1))).thenReturn(false);

      MyAmazonBookService myAmazonBookService = new MyAmazonBookService();
      myAmazonBookService.setAmazonBookService(mockAmazonBookService);

      boolean result = myAmazonBookService.purchase("product", -1);

      assertFalse(result);
   }

   @Test
   public void shouldFailWhenInsufficientInventory() throws InvalidAmazonProductAmountException, InvalidAmazonProductIdException {
      int exceededInventory = AVAILABLE_INVENTORY + 1;
      when(mockAmazonBookService.placeOrder(anyString(), eq(AVAILABLE_INVENTORY))).thenReturn(true);
      when(mockAmazonBookService.placeOrder(anyString(), eq(exceededInventory))).thenReturn(false);

      MyAmazonBookService myAmazonBookService = new MyAmazonBookService();
      myAmazonBookService.setAmazonBookService(mockAmazonBookService);
      boolean result = myAmazonBookService.purchase("product", exceededInventory);

      assertFalse(result);
   }

   @Test(expected = UnknownProductIdException.class)
   public void shouldThrowExceptionWhenGivenAnUnknownProductId() throws InvalidAmazonProductAmountException, InvalidAmazonProductIdException {
      when(mockAmazonBookService.placeOrder(eq("badProductId"), anyInt())).thenThrow(InvalidAmazonProductIdException.class);

      MyAmazonBookService myAmazonBookService = new MyAmazonBookService();
      myAmazonBookService.setAmazonBookService(mockAmazonBookService);

      myAmazonBookService.purchase("badProductId", 10);
   }
}
