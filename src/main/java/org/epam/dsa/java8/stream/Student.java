package org.epam.dsa.java8.stream;

public class Student {
    private String name;
    private Integer id;
    private String subject;
    private double percentage;

    public Student() {
    }

    public Student(String name, Integer id, String subject,double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage=percentage;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString()
    {
        return name+"-"+id+"-"+subject+"-"+percentage;
    }
}
