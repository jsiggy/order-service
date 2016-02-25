package com.bnb.service;

public class BNInvalidOrderException extends RuntimeException {
   public BNInvalidOrderException(String message) {
      super(message);
   }
}
