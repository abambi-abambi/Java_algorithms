import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class rankFinder {
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);
        int     sets = in.nextInt();

        for (int i = 0; i < sets; i++) {
            int     numQuantity = in.nextInt();
            int[] one_set = new int[numQuantity];
            for (int j = 0; j < numQuantity; j++) {
                one_set[j] = in.nextInt();
            }
            calculator(one_set, numQuantity);
        }
        in.close();
    }

    public static void calculator(int[] one_set, int numQuantity) {
//        Arrays.stream(one_set).forEach(s -> {System.out.print(s);System.out.print(" ");});
        int[]   middle_set = new int[numQuantity];
        int[]   result_set = new int[numQuantity];
        int     index = numQuantity - 1;
        int     rank = 1;
        int     max;

        for (int i = 0; i < numQuantity; i++) {
            middle_set[i] = one_set[i];
        }

        Arrays.sort(middle_set);
        max = middle_set[index];

        for (int i = 0; i < numQuantity; i++) {
            if (middle_set[index] == max || middle_set[index] == max - 1)
                result_set[index] = rank;
            else if (middle_set[index] < max - 1) {
                max = middle_set[index];
                rank = rank + 1;
                result_set[index] = rank;
            }
            index--;
        }
        
        for (int i = 0; i < numQuantity; i++) {
            final int value = one_set[i];
            int res = IntStream.range(0, numQuantity).filter(x -> middle_set[x] == value).findFirst().orElse(-1);
            System.out.print(result_set[res]);
            System.out.print(" ");
        }
        System.out.println();
    }
}