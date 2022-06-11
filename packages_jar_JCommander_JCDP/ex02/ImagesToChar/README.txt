#1. Create directories:
    echo "Create directories 'target' and 'lib'"
    mkdir target && mkdir lib
#2 Download libraries:
    echo "Download libraries 'jcommander' and 'JCDP'"
    curl https://repo1.maven.org/maven2/com/beust/jcommander/1.72/jcommander-1.72.jar -o lib/jcommander-1.72.jar
    curl https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.0/JCDP-4.0.0.jar -o lib/JCDP-4.0.0.jar
#3 Extract .jar files:
    echo "Extract .jar files"
    cd target
    jar xf ../lib/jcommander-1.72.jar
    jar xf ../lib/JCDP-4.0.0.jar
    rm -rf META-INF
    cd ..
#4. Compile files into the 'target' directory:
    echo "Compile files into the 'target' directory"
    # Files of current directory: ls
    javac -d target -cp lib/\* src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/ImageConverter.java
#5. Copy /resources:
    echo "Copy /resources"
    cp -r src/resources ./target/resources
#6. Create .jar file:
    echo "Create .jar file"
    jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .
#7. Run the program:
    echo "Run the program"
    java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN
