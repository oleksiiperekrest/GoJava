package gojava.techskills.offline8.utils;

import java.io.*;
import java.util.*;

public class FileUtils {
    public static void writeToFile(String json, String path) throws IOException {
        System.out.println("Saving data");
        FileWriter writer = new FileWriter(path);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    public static String readFromFile(String path) throws IOException {
        System.out.println("Loading data");
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String json = reader.readLine();
        return json;
    }

    public static List<String> readLines(String path) throws IOException {
        Reader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);
        List<String> lines = new ArrayList<String>();
        String line;
        do {
            line = br.readLine();
            if (!line.equals(null)) lines.add(line);
        }
        while (!line.equals(null));
        return lines;
    }

}