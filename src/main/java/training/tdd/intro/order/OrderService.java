package training.tdd.intro.order;

public class OrderService {
   private BookService bookService;

   public void setBookService(BookService bookService) {
      this.bookService = bookService;
   }

   public boolean order(String productId, int amount) {
      return bookService.purchase(productId, amount);
   }
}
