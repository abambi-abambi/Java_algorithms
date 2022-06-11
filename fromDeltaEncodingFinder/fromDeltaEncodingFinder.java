import java.util.Scanner;
import java.util.Arrays;

public class fromDeltaEncodingFinder {
	public static void main(String[] argv) {

		Scanner     in = new Scanner(System.in);
		short       size = in.nextShort();
		int         newValues[] = new int[size + 1];
		int         min;

		newValues[0] = 101;
		for (int i = 0; i < size; i++) {
			newValues[i + 1] = in.nextInt() + newValues[i];
		}

		min = Arrays.stream(newValues).min().orElse(0);

		for (int i = 0; i <= size; i++) {
			System.out.print(newValues[i] - min);
			System.out.print(" ");
		}

		System.out.println();
		in.close();
	}
}