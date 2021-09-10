package task3;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class Test {
    private int id;
    private String title;
    private String value;
    @SerializedName("values")
    private List<Test> tests;

    public Test(int id, String title, String value, List<Test> tests) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.tests = tests;
    }

    public Test(int id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public Test(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public synchronized static boolean findById(List<Test> list, int id, String value) {
        for (Test test: list) {
            if (test.getId() == id) {
                test.setValue(value);
                return true;
            }
            if (test.getTests() != null) {
               findById(test.getTests(), id, value);
            }
        }
        return false;
    }

    @Override
    public String toString() {

        if (tests == null) {
            return "{" + System.lineSeparator()
                    + "  \"id\": " + id + "," + System.lineSeparator()
                    + "  \"title\": \"" + title + '\"' + "," + System.lineSeparator()
                    + "  \"value\": \"" + value + '\"' + "," + System.lineSeparator()
                    + '}';
        } else {
            return "{" + System.lineSeparator()
                    + "  \"id\": " + id + "," + System.lineSeparator()
                    + "  \"title\": \"" + title + '\"' + "," + System.lineSeparator()
                    + "  \"value\": \"" + value + '\"' + "," + System.lineSeparator()
                    + "  \"values\": \"" + tests + '\"' + "," + System.lineSeparator()
                    + '}';
        }
    }
}
