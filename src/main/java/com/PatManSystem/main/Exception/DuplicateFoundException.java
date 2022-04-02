package com.PatManSystem.main.Exception;

public class DuplicateFoundException extends Exception{

   public DuplicateFoundException(Integer id){
        super("Data already exist for id: " + id + ". To avoid duplicate please try again.");
   }
   public DuplicateFoundException(String errMsg){
        super(errMsg);
   }
}
