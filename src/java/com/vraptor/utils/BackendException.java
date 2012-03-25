package com.vraptor.utils;

/**
 *
 * @author nicolas
 */
public class BackendException extends Exception {

    public BackendException(String message) {
        super(message);
    }   
    
    public BackendException(String message, Throwable cause) {
        super(message, cause);
    }
    
        
    
}
