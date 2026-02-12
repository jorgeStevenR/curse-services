package com.devsenior.jorgerodriguez.curseservices.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String message){
        super(message);
    }
}
