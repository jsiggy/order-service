package training.tdd.intro.order;

public class UnknownProductIdException extends RuntimeException {
   private String productId;

   public UnknownProductIdException(String productId) {
      this.productId = productId;
   }
}
