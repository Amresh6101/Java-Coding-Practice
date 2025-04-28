package org.epam.dsa.java8.fi;

import java.util.function.*;

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

        // function --  take input and return something

        Function<String,Integer> func1=String::length;
        int len=func1.apply("amresh");
        System.out.println(len);

        // UnaryOperator
        // Function that takes one argument and returns the same type.

        UnaryOperator<String> unaryOperator=String::toLowerCase;
        System.out.println(unaryOperator.apply("AMRESH"));

        //BinaryOperator
        // Takes two arguments of the same type and returns one.
        BinaryOperator<Integer> binaryOperator=(a,b)->a*b;
        System.out.println(binaryOperator.apply(3,4));

        //BiPredicate<T,U>
        // Like Predicate but takes two inputs.
        BiPredicate<String,Integer> biPredicate=(str1,val1)->str1.length()>=val1;
        System.out.println(biPredicate.test("amresh",5));

        //BiFunction
        // Takes two inputs and returns an output.
        BiFunction<String,String,String> biFunction=(str1,str2)->str1+str2;
        System.out.println(biFunction.apply("amresh","ranjan"));

        //BiConsumer
        // Takes two inputs and does something (no return).
        BiConsumer<String,String> biConsumer=(str1,str2)-> System.out.println(str1+":"+str2);
        biConsumer.accept("string1","string2");


    }
}
