package org.andrey.api;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @org.junit.jupiter.api.Order(1)
    void testA() {
        System.out.println("Running testA");
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void testB() {
        System.out.println("Running testB");
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void testC() {
        System.out.println("Running testC");
    }
}