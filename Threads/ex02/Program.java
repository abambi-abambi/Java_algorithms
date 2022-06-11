import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program {
    private static int maxModulo = 1000;
    private static int arraySize;
    private static int threadsCount;

    public static void main(String[] args) {
        if (args.length != 2 || args[0].startsWith("--arraySize=") == false
                || args[1].startsWith("--threadsCount=") == false) {
            System.out.println("Wrong arguments, please, write: \njava Program --arraySize=13 --threadsCount=3 " +
                    "\n(with numbers within the range from 1 to 2000000)");
            System.exit(-1);
        }
        arraySize = Integer.parseInt(args[0].substring("--arraySize=".length()));
        threadsCount = Integer.parseInt(args[1].substring("--threadsCount=".length()));

        if (arraySize < 1 || arraySize > 2_000_000 || threadsCount < 1 || threadsCount > arraySize) {
            System.out.println("Illegal argument: arraySize or/and threadsCount");
            System.exit(-1);
        }

        List<Integer> allNumbers = new Random().ints(arraySize, -maxModulo, maxModulo).boxed().collect(Collectors.toList());
        printCalculations(allNumbers);
    }
    private static void printCalculations(List<Integer> allNumbers) {
        int division;

        division = arraySize / threadsCount;
        System.out.println("Sum: " + allNumbers.stream().flatMapToInt(IntStream::of).sum());

        int[] threadSums = new int[threadsCount];
        for (int i = 0, j = 0; i < threadsCount; i++) {
            if (i < threadsCount - 1) {
                new CalculationResults(allNumbers.subList(j, j + division), j, j + division, threadSums, i).run();
                j += division;
            } else {
                new CalculationResults(allNumbers.subList(j, arraySize), j, arraySize, threadSums, i).run();
            }
        }
        System.out.println("Sum by threads: " + Arrays.stream(threadSums).sum());
    }
}