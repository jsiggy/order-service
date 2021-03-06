package com.bnb.service;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode @ToString
public class BNOrder {
   private BNProduct product;
   private int amount;

   public BNOrder(BNProduct product, int amount) {
      this.product = product;
      this.amount = amount;
   }

   public BNProduct getProduct() {
      return product;
   }

   public int getAmount() {
      return amount;
   }
}
