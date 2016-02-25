package training.tdd.intro.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
   @Mock
   private BookService mockBookService;

   @Test
   public void shouldUseBookServiceToPlaceOrder() {
      OrderService orderService = new OrderService();
      orderService.setBookService(mockBookService);

      orderService.order("foo", 10);

      verify(mockBookService).purchase("foo", 10);
   }
}