
/**
 * 17_FileIO.java - File Reading, Writing, and Operations
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

class FileIO {
    public static void main(String[] args) {
        // === File Class Basics ===
        File file = new File("test.txt");
        System.out.println("Exists: " + file.exists());
        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());

        // === Writing to File (FileWriter) ===
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Hello World\n");
            writer.write("Line 2");
            System.out.println("File written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // === Writing with BufferedWriter ===
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("buffered.txt"))) {
            bw.write("First line");
            bw.newLine();
            bw.write("Second line");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // === Reading with FileReader ===
        try (FileReader reader = new FileReader("output.txt")) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("File not found or error reading");
        }

        // === Reading with BufferedReader ===
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // === Scanner for reading ===
        try (Scanner scanner = new Scanner(new File("output.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // === NIO.2 (Modern approach - Java 7+) ===
        Path path = Paths.get("nio_file.txt");

        // Write
        try {
            Files.write(path, "NIO content\nLine 2".getBytes());
            Files.write(path, Arrays.asList("Line 3", "Line 4"),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read all lines
        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read as string
        try {
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // === File operations ===
        try {
            // Create directory
            Files.createDirectories(Paths.get("mydir"));

            // Copy file
            Files.copy(path, Paths.get("copy.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            // Move/Rename
            // Files.move(source, target);

            // Delete
            Files.deleteIfExists(Paths.get("copy.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cleanup
        try {
            Files.deleteIfExists(Paths.get("output.txt"));
            Files.deleteIfExists(Paths.get("buffered.txt"));
            Files.deleteIfExists(Paths.get("nio_file.txt"));
            Files.deleteIfExists(Paths.get("mydir"));
        } catch (IOException e) {
        }
    }
}
