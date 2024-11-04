// James Shoemaker
// 10/9/24
// StudentsStanding2.java p 483 7-b

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class StudentsStanding2 {
    private static final String ID_FORMAT = "00000";
    private static final String FIRST_NAME_FORMAT = "          ";
    private static final String LAST_NAME_FORMAT = "          ";
    private static final String GPA_FORMAT = "0.00";
    private static final int FNAME_LENGTH = FIRST_NAME_FORMAT.length();
    private static final int LNAME_LENGTH = LAST_NAME_FORMAT.length();
    private static final int NUMRECS = 1000;
    private static final String QUIT = "999";
    private static final String DELIMITER = ",";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path goodFile = Paths.get("c:/SDEV200Java/ch10/GoodStanding.txt");
        Path probationFile = Paths.get("c:/SDEV200Java/ch10/AcademicProbation.txt");

        String emptyRecord = createEmptyRecord();
        createEmptyFile(goodFile, emptyRecord);
        createEmptyFile(probationFile, emptyRecord);

        try (FileChannel fcGood = (FileChannel) Files.newByteChannel(goodFile, CREATE, WRITE);
            FileChannel fcProbation = (FileChannel) Files.newByteChannel(probationFile, CREATE, WRITE)) {

            System.out.print("Enter student id number >> ");
            String idString = input.nextLine();

            while (!idString.equals(QUIT)) {
                int id = parseId(idString);
                String fName = formatString(input, "Enter student's first name >> ", FNAME_LENGTH);
                String lName = formatString(input, "Enter student's last name >> ", LNAME_LENGTH);
                double gpa = parseGPA(input, "Enter GPA >> ");

                String formattedRecord = formatRecord(idString, fName, lName, gpa);
                ByteBuffer buffer = ByteBuffer.wrap(formattedRecord.getBytes());

                if (gpa >= 2.0) {
                    fcGood.position(id * emptyRecord.length());
                    fcGood.write(buffer);
                } else {
                    fcProbation.position(id * emptyRecord.length());
                    fcProbation.write(buffer);
                }

                System.out.print("Enter next student id number or " + QUIT + " to quit >> ");
                idString = input.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error message: " + e);
        }

        // Display file contents 
        System.out.println("\n--- Good Standing Students ---");
        displayFileContents(goodFile, 2.0);

        System.out.println("\n--- Academic Probation Students ---");
        displayFileContents(probationFile, 2.0);

        input.close();
    }

    private static void createEmptyFile(Path file, String s) {
        try (BufferedWriter writer = Files.newBufferedWriter(file, CREATE)) {
            for (int count = 0; count < NUMRECS; ++count)
                writer.write(s);
        } catch (Exception e) {
            System.out.println("Error message: " + e);
        }
    }

    private static String createEmptyRecord() {
        return ID_FORMAT + DELIMITER + FIRST_NAME_FORMAT + DELIMITER + LAST_NAME_FORMAT +
                DELIMITER + GPA_FORMAT + LINE_SEPARATOR;
    }

    private static String formatRecord(String id, String fName, String lName, double gpa) {
        DecimalFormat df = new DecimalFormat(GPA_FORMAT);
        return id + DELIMITER + fName + DELIMITER + lName + DELIMITER + df.format(gpa) + LINE_SEPARATOR;
    }

    private static int parseId(String idString) {
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a numeric value.");
            return -1;  // error handling
        }
    }

    private static double parseGPA(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            input.next();
        }
        double gpa = input.nextDouble();
        input.nextLine();
        return gpa;
    }

    private static String formatString(Scanner input, String prompt, int length) {
        System.out.print(prompt);
        String str = input.nextLine();
        StringBuilder sb = new StringBuilder(str);
        sb.setLength(length);
        return sb.toString();
    }

    private static void displayFileContents(Path file, double cutoff) {
        try (FileChannel fc = (FileChannel) Files.newByteChannel(file, READ)) {
            ByteBuffer buffer = ByteBuffer.allocate((int) fc.size());
            fc.read(buffer);
            buffer.flip();

            String content = new String(buffer.array());
            String[] records = content.split(LINE_SEPARATOR);

            for (String record : records) {
                String[] fields = record.split(DELIMITER);
                if (fields.length >= 4) {
                    try {
                        int id = Integer.parseInt(fields[0].trim());
                        String fName = fields[1].trim();
                        String lName = fields[2].trim();
                        double gpa = Double.parseDouble(fields[3].trim());

                        if (id > 0) {
                            String status = gpa >= cutoff ? "Above" : "Below";
                            double difference = Math.abs(gpa - cutoff);
                            System.out.printf("ID: %s, First Name: %s, Last Name: %s, GPA: %.2f, %s 2.0 by: %.2f\n",
                                    fields[0], fName, lName, gpa, status, difference);
                        }
                    } catch (NumberFormatException e) {
                        // Skip invalid records
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
        }
    }
}
