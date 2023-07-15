package ui;

import java.util.ArrayList;
import java.util.List;
import util.MyToys;


public class Menu {
    private static final List<String> optionsList = new ArrayList<>();
    private static final String headerBar = "---------------------------------";
    private static final String footerBar = "---------------------------------";
    private String menuTitle;

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    /**
     * Check for duplicated option.
     */
    public void addOptionsList(String newOption) {
        if (!optionsList.contains(newOption)) {
            optionsList.add(newOption);
        }
    }

    public void printMenu() {
        System.out.println(headerBar);
        if (optionsList.isEmpty()) {
            System.out.println("NOTHING TO PRINT");
        }
        System.out.println("WELCOME TO " + menuTitle);
        optionsList.forEach(System.out::println);
        System.out.println(footerBar);
    }

    public int getChoice() {
        int maxOption = optionsList.size();
        String inputMessage = "CHOOSE FROM [1..." + optionsList.size() + "]: ";
        String errorMessage = "YOU ARE REQUIRED TO CHOOSE FROM [1..." + optionsList.size() + "]: ";
        return MyToys.getAnInteger(inputMessage, errorMessage, 1, maxOption);
    }
}
