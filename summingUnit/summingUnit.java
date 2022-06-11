import java.util.Scanner;

public class summingUnit {
    public static void main(String[] argv) {

        Scanner     in = new Scanner(System.in);
        short       counter = in.nextShort();
        
        while (counter > 0)
        {
            System.out.println((short)(in.nextShort() + in.nextShort()));
            --counter;
        }
        in.close();
    }
}