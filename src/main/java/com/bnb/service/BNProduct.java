package com.bnb.service;

public class BNProduct {
   private int id;
   private String name;

   public BNProduct(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof BNProduct)) return false;

      BNProduct bnProduct = (BNProduct) o;

      if (id != bnProduct.id) return false;
      if (name != null ? !name.equals(bnProduct.name) : bnProduct.name != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = id;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      return result;
   }

   @Override public String toString() {
      return "BNProduct{" +
         "id=" + id +
         ", name='" + name + '\'' +
         '}';
   }
}
