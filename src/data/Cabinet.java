package data;

import util.MyToys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cabinet {
    private static final List<Person> studentList = new ArrayList<>();
    private static final String studentHeader = String.format("|%-8s|%-25s|%-10s|%6s|%-10s|%15s|", "ID", "NAME", "BIRTHDAY", "GENDER", "LEVEL", "SCORE");
    private static final String teacherHeader = String.format("|%-8s|%-25s|%-10s|%6s|%-10s|%-20s|", "ID", "NAME", "BIRTHDAY", "GENDER", "SUBJECT", "SALARY");

    public void addStudent() {
        String id, name;
        String birthday;
        boolean gender;
        String level;
        double scored;
        int pos;

        name = MyToys.getAString("INPUT A STUDENT NAME: ", "A STUDENT NAME IS REQUIRED!");
        scored = MyToys.getADouble("INPUT STUDENT SCORE: ", "STUDENT SCORE MUST BE BETWEEN 0.0 AND 10.00!", 0.0, 10.0);
        gender = MyToys.getGender("INPUT STUDENT GENDER: ", "A STUDENT GENDER IS REQUIRED!");
        level = MyToys.getAString("INPUT STUDENT LEVEL: ", "A STUDENT LEVEL IS REQUIRED!");
        do {
            id = MyToys.getID("INPUT A STUDENT ID: ", "ID MUST BE IN FORMAT SEXXXXXX (X STANDS FOR DIGIT)", "SE\\d{6}");
            pos = searchPersonByID(id);
            if (pos >= 0) {
                System.out.println("DUPLICATED ID! PLEASE TRY AGAIN");
            }
        } while (pos != -1);
        birthday = MyToys.getBirthday("INPUT A STUDENT BIRTHDAY: ", "A STUDENT BIRTHDAY MUST BE IN FORMAT dd-MM-yyyy!");
        studentList.add(new Pupil(id, name, birthday, gender, level, scored));
        System.out.println("A STUDENT IS ADDED SUCCESSFULLY!");
    }

    public int searchPersonByID(String id) {
        if (studentList.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public void displayExcellentStudents() {
        if (studentList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println(studentHeader);
            for (Person person : studentList) {
                if (person instanceof Pupil) {
                    Pupil pupil = (Pupil) person;
                    if (pupil.getScored() >= 8) {
                        pupil.showProfile();
                    }
                }
            }
        }
    }


    public void displayWeakStudents() {
        if (studentList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println(studentHeader);
            for (Person person : studentList) {
                if (person instanceof Pupil) {
                    Pupil pupil = (Pupil) person;
                    if (pupil.getScored() < 5) {
                        pupil.showProfile();
                    }
                }
            }
        }
    }

    public void addTeacher() {
        String id, name, subject;
        String birthday;
        boolean gender;
        double salary;
        int pos;

        name = MyToys.getAString("INPUT A TEACHER NAME: ", "A TEACHER NAME IS REQUIRED!");
        do {
            id = MyToys.getID("INPUT A TEACHER ID: ", "ID MUST BE IN FORMAT SEXXXXXX (X STANDS FOR DIGIT)!", "SE\\d{6}");
            pos = searchPersonByID(id);
            if (pos >= 0) {
                System.out.println("DUPLICATED ID! PLEASE TRY AGAIN");
            }
        } while (pos != -1);
        birthday = MyToys.getBirthday("INPUT A TEACHER BIRTHDAY: ", "A TEACHER BIRTHDAY MUST BE IN FORMAT dd-MM-yyyy!");
        gender = MyToys.getGender("INPUT A TEACHER GENDER: ", "A TEACHER GENDER IS REQUIRED!");
        salary = MyToys.getADouble("INPUT TEACHER SALARY: ", "TEACHER SALARY MUST BE FROM 0 TO 1000000000", 0, 1000000000);
        subject = MyToys.getAString("INPUT TEACHER SUBJECT: ", "A SUBJECT IS REQUIRED!");
        studentList.add(new Teacher(id, name, birthday, gender, subject, salary));
    }

    public void findTeacherByName() {
        String name;
        Person x;
        name = MyToys.getAString("INPUT A TEACHER NAME: ", "A TEACHER NAME IS REQUIRED!");
        x = searchPersonByName(name);
        if (x == null) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("FOUND!HERE HE/SHE IS");
            System.out.println(teacherHeader);
            x.showProfile();
        }
    }

    public void findTeacherBySalary() {
        double salary;
        Person x;
        salary = MyToys.getADouble("INPUT A TEACHER SALARY: ", "TEACHER SALARY MUST BETWEEN 0 AND 1000000000", 0, 1000000000);
        x = searchTeacherBySalary(salary);
        if (x == null) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("HERE HE/SHE IS");
            System.out.println(teacherHeader);
            x.showProfile();
        }
    }

    public Person searchPersonByName(String name) {
        if (studentList.isEmpty()) {
            return null;
        }
        for (Person person : studentList) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public Person searchTeacherBySalary(double salary) {
        if (studentList.isEmpty()) {
            return null;
        }
        for (Person person : studentList) {
            if (person instanceof Teacher && ((Teacher) person).getSalary() == salary) {
                return person;
            }
        }
        return null;
    }

    public void displaySalary() {
        if (studentList.isEmpty()) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println(teacherHeader);
            for (Person person : studentList) {
                if (person instanceof Teacher) {
                    person.showProfile();
                }
            }
        }
    }
}
