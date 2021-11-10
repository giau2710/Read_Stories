package utils;

import exception.TextFileException;

import java.io.*;

public class TextFile {
    public static String read(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException ex) {
            throw new TextFileException(ex);
        }
    }

    public static void write(String filePath, String content) {
        try {
            File file = new File(filePath);
            if (!file.exists())
                file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException ex) {
            throw new TextFileException(ex);
        }
    }

}
