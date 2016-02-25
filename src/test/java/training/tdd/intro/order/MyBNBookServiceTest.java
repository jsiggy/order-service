package training.tdd.intro.order;

import com.bnb.service.BNBookOrderService;
import com.bnb.service.BNOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MyBNBookServiceTest {

   @Mock
   BNBookOrderService mockBNBookOrderService;

   @Test
   public void shouldUseBNBookServiceToSuccessfulPlaceOrder() {

      MyBNBookService myBNBookService = new MyBNBookService();
      myBNBookService.setBNBookOrderService(mockBNBookOrderService);

      myBNBookService.purchase("foo", 10);

      verify(mockBNBookOrderService).purchase(Matchers.<BNOrder>any());
   }
}
