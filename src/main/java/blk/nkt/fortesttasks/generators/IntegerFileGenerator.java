package blk.nkt.fortesttasks.generators;

import java.nio.file.Files;
import java.nio.file.Path;

public class IntegerFileGenerator implements FileGenerator {
    @Override
    public void generate(boolean ascendingSort, String startNumber, String intervalSize,
                         String numberOfValues, String outputFilePath) {
        try {
            int start = Integer.parseInt(startNumber);
            int interval = Integer.parseInt(intervalSize);
            int numOfValues = Integer.parseInt(numberOfValues);
            int maxPossible = start + interval * (numOfValues);
            Path outputFile = FileGenerator.createFilePath(outputFilePath);
            StringBuilder result = new StringBuilder();

            if (interval < 0) {
                ascendingSort = !ascendingSort;
            }
            if (ascendingSort) {
                for (int i = 0; i < numOfValues; i++) {
                    int current = start + (int) (Math.random() * (interval + 1));
                    start += interval;
                    result.append(current).append("\n");
                }
            } else {
                for (int i = 0; i < numOfValues; i++) {
                    int current = (maxPossible - interval) + (int) (Math.random() * (interval + 1));
                    maxPossible -= interval;
                    result.append(current).append("\n");
                }
            }
            if (!Files.exists(outputFile)) {
                Files.createFile(outputFile);
            }

            Files.write(outputFile, result.toString().getBytes());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
