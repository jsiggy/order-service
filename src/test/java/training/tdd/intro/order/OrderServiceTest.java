package training.tdd.intro.order;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderServiceTest {

    @Test
    public void shouldReturnTrueIfAbleToPlaceOrderSuccessfully() {
        OrderService orderService = new OrderService();

        boolean result = orderService.order("ValidProductId", 5);

        assertTrue(result);
    }
}
