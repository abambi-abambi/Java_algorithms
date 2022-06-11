package edu.school21.printer.app;

import edu.school21.printer.logic.ImageConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Program {
    @Parameter(names = {"--white"})
    private static String white;
    @Parameter(names = {"--black"})
    private static String black;
    private static BufferedImage img = null;

    public static void main(String[] args) {
        Program main = new Program();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);

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