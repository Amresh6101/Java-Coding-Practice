package org.epam.dsa.java8.lambda;

public class TestLambda {
    public static void main(String[] args) {
        // normal way to implement interface method.
        Bird b1=new Crow();
        b1.fly();
        Bird b2=new Kite();
        b2.fly();
        Bird b3=new Eagle();
        b3.fly();

        // annoymous ways to implement the interface method

        Bird b4= new Bird() {
            @Override
            public void fly() {
                System.out.println( "This is Crow usin annoymous class!!");
            }
        };
        b4.fly();

        Bird b5=new Bird() {
            @Override
            public void fly() {
                System.out.println("This is kite using annoymous class!!!");
            }
        };
        b5.fly();

        //lambda way to implement the functional interface.
        Bird b6=()-> System.out.println("This is kite using lambda");
        b6.fly();

       // Crow.birdStaticMethod();
        Bird.birdStaticMethod();

        Bird b7=new Crow();
        b7.birdDefaultMethod();




    }
}
