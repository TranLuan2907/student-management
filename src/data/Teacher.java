package data;

import java.util.Date;

public class Teacher extends Person {
    private String subject;
    private double salary;

    public Teacher(String id, String name, String birthday, boolean gender, String subject, double salary) {
        super(id, name, birthday, gender);
        this.subject = subject;
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void showProfile() {
        String message = String.format("|%-8s|%-25s|%-10s|%-6s|%-10s|%-20f|", id, name, birthday, gender ? "MALE" : "FEMALE", subject, salary);
        System.out.println(message);
    }
}
