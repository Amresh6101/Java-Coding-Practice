package org.epam.dsa.java8.stream;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsStream {
    public static void main(String[] args) {


        List<Integer> list= Arrays.asList(2,4,5,6,8,5);
        //Collectors.toList();
        List<Integer> list1=list.stream().filter(val1->val1>5).collect(Collectors.toList());
        System.out.println(list1);

        //Collectors.toSet()

        List<Student> studentList=new ArrayList<>();

        studentList.add(new Student("Paul", 11, "Economics", 78.9));
        studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
        studentList.add(new Student("Harish", 13, "History", 83.7));
        studentList.add(new Student("Xiano", 14, "Literature", 71.5));
        studentList.add(new Student("Soumya", 15, "Economics", 77.5));
        studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
        studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
        studentList.add(new Student("Mitshu", 18, "History", 73.5));
        studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
        studentList.add(new Student("Harry", 20, "History", 71.9));


        // Collectors.toList() :
        // Collecting top 3 performing students into List
        List<Student> top3Student=studentList.stream().sorted((s1,s2)-> - Double.compare(s1.getPercentage(), s2.getPercentage())).limit(3).collect(Collectors.toList());
        System.out.println(top3Student);

        // Collectors.toSet() :
        //Collecting subjects offered into Set.
        Set<String> subjects=studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
        System.out.println(subjects);

        //Collectors.toMap() :
        // Collecting name and percentage of each student into a Map
        Map<String,Double> studentMap=studentList.stream().collect(Collectors.toMap(Student::getName, Student::getPercentage,(oldVal, newVal)->oldVal, LinkedHashMap::new));
        System.out.println(studentMap);

        //Collectors.toCollection()
        //Collecting first 3 students into LinkedList
        LinkedList<Student> studentLinkedList=studentList.stream().limit(3).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(studentLinkedList);

        // Collectors.joining() :
        // Collecting the names of all students joined as a string
        String studentNames=studentList.stream().map(Student::getName).collect(Collectors.joining(", "));
        System.out.println(studentNames);

        //Collectors.counting() :
        //Counting number of students
        System.out.println(
                "total number of students:"+
                studentList.stream().collect(Collectors.counting())
        );


        // Collectors.maxBy()
        //Collecting highest percentage.
        System.out.println(
                "calculate highest percentage:"+
                        studentList.stream().map(Student::getPercentage).collect(Collectors.maxBy((i1,i2)->Double.compare(i1,i2))).get()
        );


        // Collectors.groupingBy()
        //Grouping the students by subject
        System.out.println("====");
        Map<String,List<Student>> groupStudentBySubject=studentList.stream().collect(Collectors.groupingBy(Student::getSubject));
        System.out.println(groupStudentBySubject);

        System.out.println("=====");
        // Collectors.partitioningBy() :
        // Partitioning the students who got above 80.0% from who don’t.
        Map<Boolean,List<Student>> partitionByPercentage=studentList.stream().collect(Collectors.partitioningBy(s1->s1.getPercentage()>80));
        System.out.println(partitionByPercentage);

    }
}
