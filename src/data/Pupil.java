package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pupil extends Person {
    private String level;
    private double scored;

    public Pupil(String id, String name, String birthday, boolean gender, String level, double scored) {
        super(id, name, birthday, gender);
        this.level = level;
        this.scored = scored;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getScored() {
        return scored;
    }

    public void setScored(double scored) {
        this.scored = scored;
    }

    @Override
    public void showProfile() {
        String message = String.format("|%-8s|%-25s|%-8s|%-6s|%-10s|%4.1f|", id, name, birthday, gender ? "MALE" : "FEMALE", level, scored);
        System.out.println(message);
    }
}
