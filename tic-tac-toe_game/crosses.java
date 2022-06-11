import java.util.Scanner;

public class crosses {
	public static void main(String[] argv) {
		Scanner			in = new Scanner(System.in);
		int				sets = in.nextInt();
		StringBuilder	str = new StringBuilder("");
		int				counter;

		for (int i = 0; i < sets; i++) {
			if (str.length() > 0)
				str.delete(0, str.length());
			counter = 3;
			while (counter != 0) {
				StringBuilder	tmp_str = new StringBuilder(in.nextLine());
				if (tmp_str.length() > 0 )
					counter--;
				str.append(tmp_str);
				if (tmp_str.length() > 0)
					tmp_str.delete(0, tmp_str.length());
			}
			fieldValidator(str);
			if (i == sets) {
				System.out.println("\n");
				in.close();
				System.exit(0);
			}
		}
//		in.close();
	}
	
	public static void fieldValidator(StringBuilder str) {
		int	counterX;
		int counterZero;

		counterX = 0;
		counterZero = 0;
		for (int i = 0; i < 9; i++) {
			if (str.charAt(i) == 'X')
				counterX++;
			else if (str.charAt(i) == '0')
				counterZero++;
			else
			{};
			}
		if (counterX - counterZero > 1 || counterZero > counterX) {
			System.out.println("NO");
		}
		else if (((int)str.charAt(0) + (int)str.charAt(1) + (int)str.charAt(2) == 264 ||
			(int)str.charAt(3) + (int)str.charAt(4) + (int)str.charAt(5) == 264 ||
			(int)str.charAt(6) + (int)str.charAt(7) + (int)str.charAt(8) == 264	||
			(int)str.charAt(0) + (int)str.charAt(4) + (int)str.charAt(8) == 264	||
			(int)str.charAt(2) + (int)str.charAt(4) + (int)str.charAt(6) == 264 ||
			(int)str.charAt(0) + (int)str.charAt(3) + (int)str.charAt(6) == 264 ||
			(int)str.charAt(1) + (int)str.charAt(4) + (int)str.charAt(7) == 264 ||
			(int)str.charAt(2) + (int)str.charAt(5) + (int)str.charAt(8) == 264) &&
			counterX <= counterZero) {
			System.out.println("NO");
		}
		else if (((int)str.charAt(0) + (int)str.charAt(1) + (int)str.charAt(2) == 144 ||
			(int)str.charAt(3) + (int)str.charAt(4) + (int)str.charAt(5) == 144 ||
			(int)str.charAt(6) + (int)str.charAt(7) + (int)str.charAt(8) == 144	||
			(int)str.charAt(0) + (int)str.charAt(4) + (int)str.charAt(8) == 144	||
			(int)str.charAt(2) + (int)str.charAt(4) + (int)str.charAt(6) == 144 ||
			(int)str.charAt(0) + (int)str.charAt(3) + (int)str.charAt(6) == 144 ||
			(int)str.charAt(1) + (int)str.charAt(4) + (int)str.charAt(7) == 144 ||
			(int)str.charAt(2) + (int)str.charAt(5) + (int)str.charAt(8) == 144) &&
			counterX > counterZero) {
			System.out.println("NO");
		}
		else
			System.out.println("YES");
	}
}
