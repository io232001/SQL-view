package it.develhope.sql;
public class Student {
    private final String url;
    private final String user;
    private final String password;
    private String name;
    private String surname;
    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.url = "jdbc:mysql://localhost:3306/newdb";
        this.user = "developer";
        this.password = "passwordhere";
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void printStudentNameSurname() {
        System.out.println("Name: " + name + ", surname: " + surname);
    }
}