package com.PatManSystem.main.Exception;

public class NotFoundException extends Exception{

    public NotFoundException(Integer id){
        super("Data with id " + id + " is not found. Please try again.");
    }

    public NotFoundException(Long uli){
        super("Data with ULI " + uli + " is not found. Please try again.");
    }
}
