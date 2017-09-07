package gojava.techskills.offline8;

import com.alibaba.fastjson.JSON;
import gojava.techskills.offline8.Store.TradeQuarters;
import gojava.techskills.offline8.classes.Dossier;
import gojava.techskills.offline8.classes.Lines;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String filename = "Files/Offline8/file.txt";
        String filename2 = "Files/Offline8/task2.txt";
        String[] filename3 = new String[] {
                "Files/Offline8/3_1.txt",
                "Files/Offline8/3_2.txt",
                "Files/Offline8/3_3.txt",
                "Files/Offline8/3_4.txt"
        };

        try {
//            String json = new Scanner(new File(filename)).useDelimiter("\\Z").next();
//            Lines lines = JSON.parseObject(json, Lines.class);
//            lines.printLines();
//            System.out.println();
//
//            String json2 = new Scanner(new File(filename2)).useDelimiter("\\Z").next();
//            TradeQuarters quarters = JSON.parseObject(json2, TradeQuarters.class);
//            quarters.show();


            String[] json3 = new String[filename3.length];
            for (int i = 0; i < json3.length; i++) {
                json3[i] = new Scanner(new File(filename3[i])).useDelimiter("\\Z").next();
            }

            Dossier[] dossiers = new Dossier[json3.length];
            for (int i = 0; i < dossiers.length; i++) {
                dossiers[i] = JSON.parseObject(json3[i], Dossier.class);
            }

            int x =0; //to stop in debug

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Data corrupted");
        }

    }
}
