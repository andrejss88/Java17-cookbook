package files;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HowToWriteFile {

    public static void main(String[] args) throws IOException {

//        Files.writeString();


        // throws if /dir/ doesn't exist, but creates if only the file doesn't exist
        Path path = Paths.get("text.txt");
        try(var write = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            PrintWriter pw = new PrintWriter(write);
            pw.println("Hello World");
        }

    }
}
