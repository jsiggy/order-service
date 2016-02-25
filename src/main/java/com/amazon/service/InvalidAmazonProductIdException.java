package com.amazon.service;

public class InvalidAmazonProductIdException extends AmazonServiceException {
   public InvalidAmazonProductIdException(String message) {
      super(message);
   }
}
