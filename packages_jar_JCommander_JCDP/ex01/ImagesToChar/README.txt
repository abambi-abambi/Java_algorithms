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


#3. Copy resources:
    cp -r src/resources ./target/resources


#4. Create jar file:
    jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .


#5. Run the program:
    java -jar target/images-to-chars-printer.jar . 0

#*******
