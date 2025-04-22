package org.epam.dsa.java8.fi;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFIImplementation {
    public static void main(String[] args) {
        // lambda is one of way to implement functional interface
        TestFunctionalInterface testFunctionalInterface=()->{
            System.out.println("hello functional Interface");
        };
        testFunctionalInterface.test();

        // predicate-- take input return boolean
        // method-test()
        Predicate<String> predicate=(str)-> str.length()>5;
        System.out.println(predicate.test("amresh"));

        //consumer -- take input return nothing
        // method-accept
        Consumer<String> consumer=(str)-> System.out.println(str);
        consumer.accept("guddu");

        // supplier -- take nothing but return something
        // method-get
        Supplier<String> supplier=()-> "hello amresh";
        System.out.println(supplier.get());

    }
}
