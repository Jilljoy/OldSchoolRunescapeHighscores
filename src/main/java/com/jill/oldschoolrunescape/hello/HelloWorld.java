package com.jill.oldschoolrunescape.hello;

public class HelloWorld {

    private final String message;
    private final Long value;

    HelloWorld() {
        this.message = null;
        this.value = null;
    }

    HelloWorld(String message, Long value) {
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public Long getValue() {
        return value;
    }
}

