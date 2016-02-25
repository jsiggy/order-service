package com.bnb.service;

public class BNBookOrderService {

   private static final int MAX_BOOKS = 50;

   public int purchase(BNOrder order) {
      if (order == null || order.getProduct() == null)
         throw new BNInvalidOrderException("BNOrder or BNProduct cannot be null");
      System.out.println("calling BNB Book Service for " + order.getAmount() + " units of " + order.getProduct().getName());
      return order.getAmount() > MAX_BOOKS ? order.getAmount() : MAX_BOOKS;
   }
}
