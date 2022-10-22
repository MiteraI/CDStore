package tools;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileMethod {
    public static List<String> readLinesFromFile(String filename) {
        ArrayList<String> list = new ArrayList<>();
        File f = new File(filename);
        if (f.exists()) {
            String line;
            try {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);
                while ((line = bf.readLine()) != null) {
                    line = line.trim();
                    if (!line.equals("")) {
                        list.add(line);
                    }
                }
                bf.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return list;
    }
    public static void writeFile(String filename, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            try {
                FileWriter fw = new FileWriter(filename);
                PrintWriter pw = new PrintWriter(fw);
                for (Object item : list) {
                    pw.println(item);
                }
                fw.close();
                pw.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
