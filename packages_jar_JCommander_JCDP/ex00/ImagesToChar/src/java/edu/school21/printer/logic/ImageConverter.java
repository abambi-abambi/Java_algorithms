package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
public class ImageConverter {

    public static void convert(BufferedImage image, char white_dot, char black_dot) {
        int pixel;

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                pixel = image.getRGB(j, i);
                if ((pixel & 0x00FFFFFF) == 0) {
                    System.out.print(black_dot);
                } else {
                    System.out.print(white_dot);
                }
            }
            System.out.println();
        }
    }
}