package org.epam.dsa.java8.stream;

import java.sql.SQLOutput;
import  java.util.*;
import java.util.stream.Stream;

public class StreamBasics {
    public static void main(String[] args) {
        // parallel stream

        List<String> names=new ArrayList<>();
        names.add("David");
        names.add("Johnson");
        names.add("Samontika");
        names.add("Brijesh");
        names.add("John");
        names.add("John");
        names.add("David");
        names.add("Brijesh");

        // normal stream
       names.stream().filter((str)->str.length()>5).forEach((str)-> System.out.println(str));

        // parallel stream
        names.parallelStream().filter((str)->str.length()==4).forEach((str)-> System.out.println(str));

        // way to create stream
        Stream<Integer> st1=Stream.of(1,2,3,4,5);
        System.out.println("Stream using simple of method:"+st1.count());

        Stream<int[]> st2=Stream.of(new int[]{1,2,3,4,5});
        System.out.println("Stream using array:"+st2.count());

        System.out.println("distinct=========");
        names.stream().distinct().forEach((System.out::println));

        System.out.println("limit==========");
        names.stream().limit(3).forEach(System.out::println);

        System.out.println("Map=============");
        names.stream().map(str->str.length()).forEach(System.out::println);

        // Other versions of map() method : mapToInt(), mapToLong() and mapToDouble().

        System.out.println("Sorted======");
        names.stream().sorted().forEach(System.out::println);

        System.out.println("Sorted using comparator========");
        names.stream().sorted((str1,str2)-> -Integer.compare(str1.length(),str2.length())).forEach(System.out::println);

        System.out.println("Reduce========");
        int sum=Arrays.stream(new int[]{7,5,9,2,8,1}).reduce(1,(a,b)->a*b);
        System.out.println(sum);

        String strRes=Arrays.stream(new String[]{"hello","amresh","guddu"}).reduce("%%",(str1,str2)->str1+":"+str2).toString();
        System.out.println(strRes);

        Optional<String> firstElement=Stream.of("first","Second","Third","four").findFirst();
        System.out.println(firstElement.get());

        //toArray() : Stream to array

        List<String> names1 = new ArrayList<>();
        names1.add("David");
        names1.add("Johnson");
        names1.add("Samontika");
        names1.add("Brijesh");
        names1.add("John");
        Object[] arr1=names1.stream().limit(3).toArray();
        System.out.println("Stream to array:"+Arrays.toString(arr1));






    }
}
