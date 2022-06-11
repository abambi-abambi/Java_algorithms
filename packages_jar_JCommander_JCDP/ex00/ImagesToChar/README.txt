#Readme

#How to launch the program:

#*******

#0. Get into the directory ImagesToChar
# in case you have already inside an old folder "target", do:
    rm -rf ./target

 
#1. Create the directory "target":
    mkdir target


#2. Compile files into the "target"-directory:
    javac -d target src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/ImageConverter.java


#3. Place the file "it.bmp" (given via subject) into some directory and write the path/it.bmp as a 3-rd argument when you run the program. Lets place it inside ./ImagesToChar/ directory


#4 Run the program:
    java -classpath ./target edu.school21.printer.app.Program . 0 ./it.bmp

    #(template for) run: java -cp ./target edu.school21.printer.app.Program [char for WHILE COLOR] [char for ANOTHER COLOR] [full PATH TO .BMP IMAGE]

#*******
