// James Shoemaker 
// 10/6/24
// YouDoIt CreateFilesBasedOnState.java pg 473 

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CreateFilesBasedOnState {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path inStateFile = Paths.get("InStateCuts.txt");
        Path outOfStateFile = Paths.get("OutOfStateCuts.txt");
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "          ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final String HOME_STATE = "WI";
        final String BALANCE_FORMAT = "0000.00";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter + HOME_STATE + delimiter
                + BALANCE_FORMAT + System.getProperty("line.separator");
        final int RECSIZE = s.length();
        FileChannel fcIn = null;
        FileChannel fcOut = null;
        String idString;
        int id;
        String name, state;
        double balance;
        final String QUIT = "999";

        createEmptyFile(inStateFile, s);
        createEmptyFile(outOfStateFile, s);

        try {
            fcIn = (FileChannel) Files.newByteChannel(inStateFile, CREATE, WRITE);

            fcOut = (FileChannel) Files.newByteChannel(outOfStateFile, CREATE, WRITE);

            System.out.print("Enter customer account number >> ");
            idString = input.nextLine();

            while (!(idString.equals(QUIT))) {
                id = Integer.parseInt(idString);

                System.out.print("Enter name for customer >> ");
                name = input.nextLine();

                StringBuilder sb = new StringBuilder(name);
                sb.setLength(NAME_LENGTH);
                name = sb.toString();

                System.out.print("Enter state >> ");
                state = input.nextLine();

                System.out.print("Enter balance >> ");
                balance = input.nextDouble();
                input.nextLine();

                DecimalFormat df = new DecimalFormat(BALANCE_FORMAT);

                s = idString + delimiter + name + delimiter + state + delimiter + df.format(balance)
                        + System.getProperty("line.separator");

                byte data[] = s.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);

                if (state.equals(HOME_STATE)) {
                    fcIn.position(id * RECSIZE);
                    fcIn.write(buffer);
                } else {
                    fcOut.position(id * RECSIZE);
                    fcOut.write(buffer);
                }

                System.out.print("Enter next customer account number or " + QUIT + " to quit >> ");
                idString = input.nextLine();
            }
            fcIn.close();
            fcOut.close();
        } catch (Exception e) {
            System.out.println("Error message: " + e);
        }

        input.close();
    }

    private static void createEmptyFile(Path file, String s) {
        final int NUMRECS = 1000;

        try {
            OutputStream outputStr = new BufferedOutputStream(
                    Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));

            for (int count = 0; count < NUMRECS; ++count)
                writer.write(s, 0, s.length());

            writer.close();
        } catch (Exception e) {
            System.out.println("Error message: " + e);
        }
    }
}

