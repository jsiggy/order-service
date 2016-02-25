package com.amazon.service;

public class InvalidAmazonProductAmountException extends AmazonServiceException {
   public InvalidAmazonProductAmountException(String message) {
      super(message);
   }
}
