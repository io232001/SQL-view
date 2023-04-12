package it.develhope.sql;
import java.sql.*;
import java.util.ArrayList;
public class Start {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        String url       = "jdbc:mysql://localhost:3306/newdb";
        String user      = "developer";
        String password  = "passwordhere";
        connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String str = "CREATE VIEW italian_students AS\n" +
                "SELECT last_name, first_name\n" +
                "FROM student\n" +
                "WHERE Country = \"Italy\";";
        String str1 = "CREATE VIEW german_students AS\n" +
                "SELECT last_name, first_name\n" +
                "FROM student\n" +
                "WHERE Country = \"Germany\";";
        statement.executeUpdate(str);
        statement.executeUpdate(str1);
        ArrayList <Student> italianStudent = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name FROM italian_students");
        while (resultSet.next()){
            italianStudent.add(new Student(resultSet.getString("first_name"), resultSet.getString("last_name")));
        }
        for (Student name : italianStudent) {
            name.printStudentNameSurname();
        }
        ArrayList <Student> germanStudent = new ArrayList<>();
        ResultSet resultSet1 = statement.executeQuery("SELECT first_name, last_name FROM german_students");
        while (resultSet1.next()){
            germanStudent.add(new Student(resultSet1.getString("first_name"), resultSet1.getString("last_name")));
        }
        for (Student name : germanStudent) {
            name.printStudentNameSurname();
        }
        connection.close();
    }
}
