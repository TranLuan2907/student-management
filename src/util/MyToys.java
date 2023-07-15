package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.time.ZoneId;
public class MyToys {
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
    private static Scanner in = new Scanner(System.in);

    public static int getAnInteger(String inputMessage, String errorMessage, int lowerBound, int upperBound) {
        int n, temp;
        if (lowerBound > upperBound) {
            temp = lowerBound;
            lowerBound = upperBound;
            upperBound = temp;
        }

        while (true) {
            try {
                System.out.print(inputMessage);
                n = Integer.parseInt(in.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static int getAnInteger(String inputMessage, String errorMessage) {
        int n;
        while (true) {
            try {
                System.out.print(inputMessage);
                n = Integer.parseInt(in.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static double getADouble(String inputMessage, String errorMessage, double upperBound, double lowerBound) {
        double n, temp;
        if (lowerBound > upperBound) {
            temp = lowerBound;
            lowerBound = upperBound;
            upperBound = temp;
        }

        while (true) {
            try {
                System.out.print(inputMessage);
                n = Double.parseDouble(in.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static double getADouble(String inputMessage, String errorMessage) {
        double n;
        while (true) {
            try {
                System.out.print(inputMessage);
                n = Double.parseDouble(in.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static String getAString(String inputMessage, String errorMessage) {
        String n;
        while (true) {
            System.out.print(inputMessage);
            n = in.nextLine().trim();
            if (n.isEmpty()) {
                System.out.println(errorMessage);
            } else
                return n;
        }
    }

    public static String getID(String inputMessage, String errorMessage, String format) {
        String n;
        boolean match;
        while (true) {
            System.out.print(inputMessage);
            n = in.nextLine().trim().toUpperCase();
            match = n.matches(format);
            if (n.isEmpty() || !match) {
                System.out.println(errorMessage);
            } else
                return n;
        }
    }

    public static boolean getGender(String inputMessage, String errorMessage) {
        String gender;
        while (true) {
            System.out.print(inputMessage);
            gender = in.nextLine().trim().toUpperCase();
            if (gender.equals("MALE")) {
                return true;
            } else if (gender.equals("FEMALE")) {
                return false;
            } else
                System.out.println(errorMessage);
        }
    }

    public static String getBirthday(String inputMessage, String errorMessage) {
        while (true) {
            System.out.print(inputMessage);
            String input = in.nextLine().trim();
            if (validateBirthday(input)) {
                return input;
            } else {
                System.out.println(errorMessage);
            }
        }
    }

    public static boolean validateBirthday(String birthday) {
        try {
            LocalDate parsedDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            int day = parsedDate.getDayOfMonth();
            int month = parsedDate.getMonthValue();

            // Check day and month ranges
            return day >= 1 && day <= 31 && month >= 1 && month <= 12;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
