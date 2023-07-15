package studentmanagement;

import data.Cabinet;
import ui.Menu;

public class Studentmanagement {
    public static void main(String[] args) {
        Menu menu = new Menu("STUDENT MANAGEMENT SYSTEM");
        menu.addOptionsList("1. INPUT STUDENT PROFILE");
        menu.addOptionsList("2. DISPLAY EXCELLENT STUDENT");
        menu.addOptionsList("3. DISPLAY WEAK STUDENT");
        menu.addOptionsList("4. INPUT TEACHER PROFILE");
        menu.addOptionsList("5. FIND TEACHER PROFILE BY NAME");
        menu.addOptionsList("6. DISPLAY TEACHER SALARY");
        menu.addOptionsList("7. QUIT");

        Cabinet cage = new Cabinet();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1 -> cage.addStudent();
                case 2 -> cage.displayExcellentStudents();
                case 3 -> cage.displayWeakStudents();
                case 4 -> cage.addTeacher();
                case 5 -> cage.findTeacherByName();
                case 6 -> cage.displaySalary();
                case 7 -> System.out.println("SEE YOU NEXT TIME!");
            }
        } while (choice != 7);

    }
}
