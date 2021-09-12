package task3;

import com.google.gson.Gson;
import java.io.*;

public class GsonParserTest {
    public Root parse(String filename) throws Exception{
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Root.class);
        } catch (FileNotFoundException e) {
            throw e;
        }
    }
}
