package task3;

import com.google.gson.annotations.SerializedName;
import java.util.*;

public class Root {
    private List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "{" + System.lineSeparator()
                + "\"tests\": " + tests
                + '}';
    }
}
