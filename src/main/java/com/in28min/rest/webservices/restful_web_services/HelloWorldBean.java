package com.in28min.rest.webservices.restful_web_services;

public class HelloWorldBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorld Bean: message = " + message;
    }
}
