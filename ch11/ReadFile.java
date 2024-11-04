// James Shoemaker 
// 10/6/24
// Fig 11-20 pg 455

import java.io.*;
import java.nio.file.*;

public class ReadFile {
    public static void main(String[] args) {
        Path file = Paths.get("ch11/Figures/Grades.txt");
        InputStream input = null;

        try {
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = null;

            s = reader.readLine();

            System.out.println(s);

            input.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}