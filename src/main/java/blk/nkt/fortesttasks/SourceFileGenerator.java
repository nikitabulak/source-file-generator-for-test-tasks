package blk.nkt.fortesttasks;

import blk.nkt.fortesttasks.generators.IntegerFileGenerator;
import blk.nkt.fortesttasks.generators.StringFileGenerator;

import java.util.List;

/* Аргументы командной строки:
 * - режим сортировки, необязательный аргумент (-a (ascending) или -d (descending), по умолчанию используется -a)
 * - тип генерируемых значений, обязательный аргумент
 *   - Для генерации String: -s *минимальная длина строки* *максимальная длина строки* *количество генерируемых значений*
 *   - Для генерации int: -i *минимальное/максимальное стартовое число* *длина интервала генерации* *количество генерируемых значений*
 * - название выходного файла, обязательный аргумент (может включать абсолютный или относительный путь до него)
 * - подсказка, необязательный аргумент: -h
 */
public class SourceFileGenerator {
    private static final List<String> AVAILABLE_FIRST_ARGUMENTS_LIST = List.of(new String[]{"-a", "-d", "-s", "-i"});
    private static final List<String> AVAILABLE_SECOND_ARGUMENTS_LIST = List.of(new String[]{"-s", "-i"});
    private static final StringFileGenerator stringFileGenerator = new StringFileGenerator();
    private static final IntegerFileGenerator integerFileGenerator = new IntegerFileGenerator();

    public static void main(String[] args) {
        boolean ascendingSort = true;
        int argumentsStartingIndex;
        if (args[0].equals("-h")) {
            printArguments();
            System.exit(1);
        }
        if (args.length < 5 || args.length > 6) {
            System.out.println("Неверные тип/параметры генерируемых значений или название выходного файла!");
            printArguments();
            System.exit(1);
        }
        checkFirstArgument(args[0]);
        if (args[0].endsWith("a") || args[0].endsWith("d")) {
            if (args[0].endsWith("d")) {
                ascendingSort = false;
            }
            argumentsStartingIndex = 2;
        } else {
            argumentsStartingIndex = 1;
        }

        checkSecondArgument(args[argumentsStartingIndex - 1]);
        if (args[argumentsStartingIndex - 1].endsWith("s")) {
            stringFileGenerator.generate(ascendingSort, args[argumentsStartingIndex], args[argumentsStartingIndex + 1],
                    args[argumentsStartingIndex + 2], args[argumentsStartingIndex + 3]);
        } else {
            integerFileGenerator.generate(ascendingSort, args[argumentsStartingIndex], args[argumentsStartingIndex + 1],
                    args[argumentsStartingIndex + 2], args[argumentsStartingIndex + 3]);
        }
    }

    private static void checkFirstArgument(String argument) {
        if (!AVAILABLE_FIRST_ARGUMENTS_LIST.contains(argument)) {
            System.out.println("Неверные аргументы командной строки!");
            printArguments();
            System.exit(1);
        }
    }

    private static void checkSecondArgument(String argument) {
        if (!AVAILABLE_SECOND_ARGUMENTS_LIST.contains(argument)) {
            System.out.println("Неверные аргументы командной строки!");
            printArguments();
            System.exit(1);
        }
    }

    private static void printArguments() {
        System.out.println("Доступные аргументы: \n" +
                "-a - необязательный, сортировка по возрастанию;\n" +
                "-d - необязательный, сортировка по убыванию;\n" +
                "-s *минимальная длина строки* *максимальная длина строки* *количество генерируемых значений* - обязательный, для генерации строковых значений;\n" +
                "-i *минимальное/максимальное стартовое число* *длина интервала генерации* *количество генерируемых значений* - обязательный, " +
                "для генерации целочисленных значений;\n\n" +
                "название выходного файла (может включать абсолютный или относительный путь до него), обязательный.");
    }
}