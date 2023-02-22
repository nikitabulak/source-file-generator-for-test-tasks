package blk.nkt.fortesttasks.generators;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class StringFileGenerator implements FileGenerator {
    @Override
    public void generate(boolean ascendingSort, String minimalLength, String maximumLength,
                         String numberOfValues, String outputFilePath) {
        try {
            int minLength = Integer.parseInt(minimalLength);
            int maxLength = Integer.parseInt(maximumLength);
            int numOfValues = Integer.parseInt(numberOfValues);
            Path outputFile = FileGenerator.createFilePath(outputFilePath);
            List<String> result = new ArrayList<>();
            char startChar;
            int alphabetLength = 26;
            Random random = new Random();

            for (int i = 0; i < numOfValues; i++) {
                StringBuilder currentString = new StringBuilder();
                int limit = minLength + random.nextInt((maxLength - minLength) + 1);//+1 делает возможной длину строки = maxLength
                for (int j = 0; j < limit; j++) {
                    boolean isCapital = random.nextBoolean();
                    if (isCapital) {
                        startChar = 65;
                    } else {
                        startChar = 97;
                    }
                    char currentChar = (char) (startChar + random.nextInt(alphabetLength));
                    currentString.append(currentChar);
                }
                currentString.append("\n");
                result.add(currentString.toString());
            }
            if (ascendingSort) {
                result.sort(Comparator.naturalOrder());
            } else {
                result.sort(Comparator.reverseOrder());
            }

            Files.write(outputFile, result);
            for (String string : result) {
                System.out.println(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
