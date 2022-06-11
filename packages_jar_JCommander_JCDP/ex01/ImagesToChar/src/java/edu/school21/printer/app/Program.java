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
        if (args.length != 2 || args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Error: incorrect args. Please, run the program this way: " +
                    "\njava -jar target/images-to-chars-printer.jar . 0" +
                    "\nor choose another symbols for drawing istead of '.' and/or '0'");
            System.exit(-1);
        }
        white = args[0].charAt(0);
        black = args[1].charAt(0);
        String filepath = "/resources/image.bmp";
        try {
            img = ImageIO.read(Program.class.getResource(filepath));
        } catch (IOException e) {
            System.err.println("Error: incorrect .bmp-file or path to file [/resources/*.bmp] or permissions of file");
            System.exit(-1);
        }
        ImageConverter.convert(img, white, black);
    }
}