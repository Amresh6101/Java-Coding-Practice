package org.epam.dsa.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student1 implements Comparable<Student1>{
    private int roll;
    private String name;
    private double percentage;

    public Student1() {
    }

    public Student1(int roll, String name, double percentage) {
        this.roll = roll;
        this.name = name;
        this.percentage = percentage;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public String toString(){
        return "[roll:"+roll+",name:"+name+",percentage:"+percentage+"]";
    }

    @Override
    public int compareTo(Student1 o) {
        return this.getName().compareTo(o.getName());
    }
}


public class ComparableSorting {
    public static void main(String[] args) {
        Student1 s1=new Student1(2,"ali",78.90);
        Student1 s2=new Student1(5,"bhaskar",70.65);
        Student1 s3=new Student1(1,"amar",90.75);
        Student1 s4=new Student1(3,"pavani",92.35);
        List<Student1> list1=new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        list1.add(s4);
        System.out.println("Before the sorting:");
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println("after sorting:");
        System.out.println(list1);
    }
}
