package training.tdd.intro.order;

import com.bnb.service.BNBookOrderService;
import com.bnb.service.BNOrder;
import com.bnb.service.BNProduct;

public class MyBNBookService implements BookService {
   private BNBookOrderService bnBookOrderService;

   public void setBNBookOrderService(BNBookOrderService bnBookOrderService) {
      this.bnBookOrderService = bnBookOrderService;
   }

   public boolean purchase(String productId, int amount) {
      bnBookOrderService.purchase(new BNOrder(new BNProduct(1, productId), amount));
      return false;
   }
}
