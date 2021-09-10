package task3;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Test> result = new GsonParserTest().parse(args[0]).getTests();
        List<Test> resource = new GsonParserValue().parse(args[1]).getTests();
        for (Test resourceTest: resource) {
            int resourceId = resourceTest.getId();
            String resourceValue = resourceTest.getValue();
            Test.findById(result, resourceId, resourceValue);
        }
        Root resRoot = new Root();
        resRoot.setTests(result);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(new File("report.json"))) {
            gson.toJson(resRoot, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
