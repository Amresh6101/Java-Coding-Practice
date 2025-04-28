package org.epam.dsa.java8.lambda;

public interface Bird {
    void fly();
    static void birdStaticMethod(){
        System.out.println("This is static method from Bird interface introduce in java-8");
    }
    default void birdDefaultMethod(){
        System.out.println("This is default method of bird interface");
    }
}
