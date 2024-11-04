// James Shoemaker 
// 10/6/24
// Fig 11-18 pg 454

import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class FileOut {
    public static void main(String[] args) {
        Path file = Paths.get("ch11/Figures/Grades.txt");
        String s = "ABCDF";
        byte[] data = s.getBytes();
        OutputStream output = null;

        try {
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            output.write(data);
            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
    }
}