package edu.school21.printer.app;

import edu.school21.printer.logic.ImageConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {
    private static char white;
    private static char black;
    private static BufferedImage img = null;

    public static void main(String[] args) {
        if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Error: incorrect args. Please, write: \nProgram x y path_to/.bmp " +
                    "\nor choose another symbols istead of 'x' and/or 'y' and another white-black image in .bmp-file");
            System.exit(-1);
        }
        white = args[0].charAt(0);
        black = args[1].charAt(0);

        try {
            img = ImageIO.read(new File(args[2]));
        } catch (IOException e) {
            System.err.println("Error: incorrect .bmp-file or path to file or permissions of file");
            System.exit(-1);
        }
        ImageConverter.convert(img, white, black);
    }
}