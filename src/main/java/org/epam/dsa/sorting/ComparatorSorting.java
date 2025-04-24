package org.epam.dsa.sorting;
import  java.util.*;

class Student{
    private int roll;
    private String name;
    private double percentage;

    public Student() {
    }

    public Student(int roll, String name, double percentage) {
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

}
 class SortByMarks implements Comparator<Student>{

     @Override
     public int compare(Student o1, Student o2) {
         return Double.compare(o2.getPercentage(), o1.getPercentage());
     }
 }

public class ComparatorSorting {
    public static void main(String[] args) {
        Student s1=new Student(2,"ali",78.90);
        Student s2=new Student(5,"bhaskar",70.65);
        Student s3=new Student(1,"amar",90.75);
        Student s4=new Student(3,"pavani",92.35);
        List<Student> list1=new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        list1.add(s4);
        System.out.println("Before the sorting");
        System.out.println(list1);
        Collections.sort(list1,new SortByMarks());
        System.out.println("after the sorting");
        System.out.println(list1);

    }
}
