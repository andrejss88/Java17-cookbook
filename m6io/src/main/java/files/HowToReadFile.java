package files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class HowToReadFile {

    public static void main(String[] args) throws IOException {

        /**
         * Java Fundamentals: Input/Output
         * M3: last clips
         * BufferedReader > FileReader > File + while loop
         * then:
         * Try with resources and use Paths.get() + also use Files.newBufferedReader()
         * https://stackoverflow.com/questions/5868369/how-can-i-read-a-large-text-file-line-by-line-using-java
         *
         */

        System.out.println(" == Read String");
        System.out.println(readSmallFile("file2.txt"));

        System.out.println(" == Line by line");
        System.out.println(readLineByLine("file2.txt"));

        System.out.println(" == BR old way");
        System.out.println(readWithBufferedReaderOldWay("file2.txt"));

        System.out.println(" == BR new way");
        readWithBufferedReaderNewWay("file2.txt");

    }

    // 1) Start small and simple
    public static String readSmallFile(String pathToFile) throws IOException {
        return Files.readString(Path.of(pathToFile));

    }

    // 2) Read line by line now
    public static List<String> readLineByLine(String pathToFile) throws IOException {
        return Files.readAllLines(Path.of(pathToFile));
    }

    // 3) Print with BufferedReader old way - only quick scroll
    public static String readWithBufferedReaderOldWay(String path) {
        BufferedReader objReader = null;
        StringBuilder fileContent = new StringBuilder();
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(path));
            while ((strCurrentLine = objReader.readLine()) != null) {
                fileContent.append(strCurrentLine).append(" ");
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } finally {
            if (objReader != null) {
                try {
                    objReader.close();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }

        }
        return fileContent.toString();
    }

    // 4) Print with BufferedReader new way
    public static void readWithBufferedReaderNewWay(String pathToFile) {
        Path path = Paths.get(pathToFile);

        try(Stream<String> lines = Files.newBufferedReader(path).lines()) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
