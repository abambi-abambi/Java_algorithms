import java.util.Scanner;

public class server_one {
	public static void main(String[] argv) {

		Scanner	in = new Scanner(System.in);
		int		sets = in.nextInt();
		StringBuilder	str = new StringBuilder("");

		for (int i = 0; i < sets; i++) {
			in.nextLine();
			int quantity = in.nextInt();
			int result = 0;
			for (int j = 0; j < quantity; j++) {
				int time = in.nextInt();
				int duration = in.nextInt();
				if (time <= result) {
					result = result + duration;
				} else {
					result = time + duration;
				}
				str.append(Integer.toString(result));
				str.append(" ");
			}
			str.append("\n");
		}
		in.close();
		System.out.print(str);
	}
}