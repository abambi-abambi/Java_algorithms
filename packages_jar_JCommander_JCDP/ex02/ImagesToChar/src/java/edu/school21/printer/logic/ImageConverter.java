package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
public class ImageConverter {

    public static void convert(BufferedImage image, String white_dot, String black_dot) {
        int pixel;
        ColoredPrinter printer = new ColoredPrinter();

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                pixel = image.getRGB(j, i);
                if ((pixel & 0x00FFFFFF) == 0) {
                    printer.print(" ", Ansi.Attribute.NONE,
                            Ansi.FColor.NONE, Ansi.BColor.valueOf(black_dot));
                } else {
                    printer.print(" ", Ansi.Attribute.NONE,
                            Ansi.FColor.NONE, Ansi.BColor.valueOf(white_dot));
                }
            }
            System.out.println();
        }
    }
}