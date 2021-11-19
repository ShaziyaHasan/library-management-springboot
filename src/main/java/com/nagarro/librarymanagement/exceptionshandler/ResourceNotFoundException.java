/**
 * ResourceNotFoundException
 * 
 * @author shaziyahasan
 *
 * Custom exception handler class
 */

package com.nagarro.librarymanagement.exceptionshandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
