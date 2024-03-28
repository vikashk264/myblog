package com.myblog.blogapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private long fieldValue;

    // constructor to initialize the variables
    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) { // what message you want to display accordingly create variable
        // String format does is that resourceName,.... is substituted with %s.
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        // Post not found with id : 1
        this.resourceName = resourceName; // resource name is Post
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }
    public String getFieldName() {
        return fieldName;
    }
    public long getFieldValue() {
        return fieldValue;
    }
}
