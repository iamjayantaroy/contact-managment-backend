package com.contact.contact_managment.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("User not found the user with id "+id);
    }
}
