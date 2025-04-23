package org.epam.dsa.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;

public class BoxedStream {
    public static void main(String[] args) {
        /*

        Java Stream API has been designed to work with objects, similar to Collections API. Streams do not treat the primitive types the same as objects.
        In Stream API, a stream of primitives can be represented by the following 3 classes:

        IntStream
        LongStream
        DoubleStream

        To convert from a stream of primitives to a stream of objects, these classes provide boxed() method that returns a Stream consisting of the elements of the given stream, each boxed to an object of the corresponding wrapper class.

         */
        List<Integer> list1 =Stream.of(1,2,3,4).collect(Collectors.toList());
        System.out.println(list1);
        // 1,2,3,4 acting as Integer object not primitive value

        Stream<Integer> stream= IntStream.of(1,2,3,4).boxed().distinct();
        System.out.println(stream.collect(Collectors.toList()));

    }
}
