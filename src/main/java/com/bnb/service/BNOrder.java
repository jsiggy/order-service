package com.bnb.service;

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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof BNOrder)) return false;

      BNOrder bnOrder = (BNOrder) o;

      if (amount != bnOrder.amount) return false;
      if (product != null ? !product.equals(bnOrder.product) : bnOrder.product != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = product != null ? product.hashCode() : 0;
      result = 31 * result + amount;
      return result;
   }

   @Override public String toString() {
      return "BNOrder{" +
         "product=" + product +
         ", amount=" + amount +
         '}';
   }
}
