package org.epam.dsa.java8;

import java.util.HashMap;
import java.util.Objects;

public class EqualsAndHashCode {
    public static void main(String[] args) {
        Person p1=new Person(12,"ramu");
        Person p2=new Person(12,"ramu");
        Person p3=new Person(13,"shyam");
        System.out.println("Person p1 hashcode:"+ p1.hashCode());
        System.out.println("Person p2 hashcode:"+ p2.hashCode());
        System.out.println("Person p3 hashcode:"+ p3.hashCode());


        System.out.println(p1.equals(p2)); // it returns false which is incorrect both object have same content then why showing false.
                                           // inorder to resolve this issue we have to override the equals methods.

        // after overriding it return true;
        // still their address is different
        System.out.println(p1);
        System.out.println(p2);

        // how to get same hashcode
        HashMap<Person,Integer> hashMap=new HashMap<>();
        hashMap.put(p1,1);
        hashMap.put(p2,2);
        hashMap.put(p3,3);
        System.out.println(hashMap);
        // output: {org.epam.dsa.java8.Person@3feba861=2, org.epam.dsa.java8.Person@5f184fc6=1}
        // same content but required two position to store the data.
        // in order to add as a one element we have override the hashcode value;
    }
}


class Person{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public  boolean equals(Object obj){
        Person p1=(Person) obj;
        return (p1.age==this.age) && (p1.name.equals(this.name));
    }


    @Override
    public int hashCode() {
       return Objects.hash(age, name);
       // return 1;
    }
}
