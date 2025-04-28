package org.epam.dsa.java8.stream;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class StreamEmployeeBasedQuestion {
    public static void main(String[] args) {
        List<StreamEmployee> empList = new ArrayList<>();
        empList.add(new StreamEmployee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new StreamEmployee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new StreamEmployee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new StreamEmployee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new StreamEmployee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new StreamEmployee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new StreamEmployee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new StreamEmployee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new StreamEmployee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));

        //Group the Employees by city.
        System.out.println(
                "Employee grouped by city:"+
                        empList.stream().collect(Collectors.groupingBy(StreamEmployee::getCity))
        );
        //Group the Employees by age.
        System.out.println(
                "Group the Employees by age:"+
                        empList.stream().collect(Collectors.groupingBy(StreamEmployee::getAge))
        );

        // Find the count of male and female employees present in the organization.
        // we can write StreamEmployee::getGender into lambda expression: (var_of_type_StreamEmployee)->var.methodNameOfStreamEmployee
        //(stEmp)->stEmp.getGender
       Map<String,Long> countOfMaleAndFemale= empList.stream().collect(Collectors.groupingBy(StreamEmployee::getGender,Collectors.counting()));
        System.out.println("Count of male and female in organization:"+ countOfMaleAndFemale);

        // Print the names of all departments in the organization.
       Set<String> allDept= empList.stream().map(StreamEmployee::getDeptName).collect(Collectors.toSet());
       System.out.println("names of all departments in the organization:"+ allDept);

       //Print employee details whose age is greater than 28.
        System.out.println("Employee details whose age is greater than 28:");
        empList.stream().filter((emp1)->emp1.getAge()>28).collect(Collectors.toList()).forEach(System.out::println);


        //  Find maximum age of employee.
        System.out.println("maximum age of employee.");
        System.out.println(empList.stream().max((emp1,emp2)-> Integer.compare(emp1.getAge(),emp2.getAge())));

        //Print Average age of Male and Female Employees.
        System.out.println(
                "Average age of Male and Female Employees:"+
                empList.stream().collect(Collectors.groupingBy((emp1)->emp1.getGender(),Collectors.averagingInt((emp2)-> emp2.getAge())))
        );


        // Print the number of employees in each department.
        Map<String,Long> countOfEmpInEachDepartment= empList.stream().collect(Collectors.groupingBy((emp1)->emp1.getDeptName(),Collectors.counting()));
        System.out.println("number of employees in each department"+ countOfEmpInEachDepartment);

        StreamEmployee streamEmployee=empList.stream().max((emp1,emp2)->Integer.compare(emp1.getAge(), emp2.getAge())).get();
        System.out.println("oldest employee by age:"+ streamEmployee);

        Map<String,Optional<StreamEmployee>> streamEmployeeMap=empList.stream().collect(Collectors.groupingBy((emp1)->emp1.getDeptName(),Collectors.maxBy((emp2,emp3)->Integer.compare(emp2.getYearOfJoining(), emp3.getYearOfJoining()))));
        System.out.println();

    }

}
