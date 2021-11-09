package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Write {
    public static void writeJsonFile(String jsonString,String pathFile) throws IOException {
        File jsonFile = new File(pathFile);
        FileWriter jsonWriter = new FileWriter(jsonFile);
        jsonWriter.write(String.valueOf(jsonString));
        jsonWriter.close();
    }
}
