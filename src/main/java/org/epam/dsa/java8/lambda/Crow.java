package org.epam.dsa.java8.lambda;

public class Crow implements Bird{
    @Override
    public void fly() {
        System.out.println("This is Crow!!");
    }

    @Override
    public  void birdDefaultMethod(){
        System.out.println("This is crow class default method!!!");
    }

}
