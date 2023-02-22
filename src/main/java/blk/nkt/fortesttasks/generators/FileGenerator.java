package blk.nkt.fortesttasks.generators;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public interface FileGenerator {
    static Path createFilePath(String outputFilePath) {
        try {
            return Path.of(outputFilePath);
        } catch (InvalidPathException e) {
            e.printStackTrace();
            System.out.println("\nНеправильный путь выходного файла. Файл defaultOutput.txt " +
                    "будет размещен в каталоге вместе с jar-архивом.\n");
            return Path.of("defaultOutput.txt");
        }
    }

    void generate(boolean ascendingSort, String minimalLength, String maximumLength,
                  String numberOfValues, String outputFilePath);
}
