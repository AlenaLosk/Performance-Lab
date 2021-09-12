package task3;

import java.util.List;

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
