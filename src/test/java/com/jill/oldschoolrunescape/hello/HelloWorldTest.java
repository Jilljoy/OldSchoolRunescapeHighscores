package com.jill.oldschoolrunescape.hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

class HelloWorldTest {

    @Test
    public void testConstructor() {
        HelloWorld helloWorld = new HelloWorld();

        assertNull(helloWorld.getMessage());
        assertNull(helloWorld.getValue());

        helloWorld = new HelloWorld("Message", 12L);

        assertEquals("Message", helloWorld.getMessage());
        assertEquals(Long.valueOf(12), helloWorld.getValue());
    }

}