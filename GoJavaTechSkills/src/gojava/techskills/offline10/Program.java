package gojava.techskills.offline10;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Program extends Application{

    @Override
    public void start(Stage primaryStage) {

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void oldMain(String[] args) {
        try {
            String filename = "Files/Offline10/links.txt";

            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ExecutorService threadPool = Executors.newFixedThreadPool(5);
            String line;
            ArrayList<String> lines = new ArrayList<>();

            while((line=bufferedReader.readLine())!=null && line.length()!=0) {
                lines.add(line);
            }
            System.out.println(lines.toString());
            System.out.println();

            for (String address : lines) {
                threadPool.execute(() -> {
                        long startTime = System.currentTimeMillis();
                        loadFile(address);
                        long finishTime = System.currentTimeMillis();
                        long elapsedTime = finishTime - startTime;
                        System.out.println("File " + address + " loaded\nElapsed time: " + elapsedTime + "\n");
                });
            }
            threadPool.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadFile(String line) {
        try {
            //            line.lastIndexOf('/');
            String[] strings = line.split("/");
            String filename = strings[strings.length - 1];
            URL url = new URL(line);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) " +
                            "Chrome/23.0.1271.95 Safari/537.11");
            InputStream in = connection.getInputStream();

            FileOutputStream fos = new FileOutputStream(new File("Files/Offline10/cache/" +
                    filename));
            byte[] buf = new byte[512];
            while (true) {
                int len = in.read(buf);
                if (len == -1) {
                    break;
                }
                fos.write(buf, 0, len);
            }
            in.close();
            fos.flush();
            fos.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
