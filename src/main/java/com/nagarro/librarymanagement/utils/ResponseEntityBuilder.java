/**
 * ResponseEntityBuilder
 * 
 * @author shaziyahasan
 *
 * Utility class for ResponseEntity
 */
 
package com.nagarro.librarymanagement.utils;

import org.springframework.http.ResponseEntity;
import com.nagarro.librarymanagement.exceptionshandler.ApiError;

public class ResponseEntityBuilder {
	public static ResponseEntity<Object> build(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
