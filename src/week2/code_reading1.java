package week2;

import java.io.*;
import java.util.Scanner;

public class code_reading1 {
    public static void main(String[] args) throws IOException{

        // scanner to get input and output file names
        Scanner kb = new Scanner(System.in);

        System.out.print("What's the name of the input file? ");
        String inFileName = kb.nextLine();
        System.out.print("What's the name of the output file? ");
        String outFileName = kb.nextLine();

        // declare scanner and writer
        Scanner inFile;
        PrintWriter outFile;

        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        // set stream of file or error if it does not exist
        try{
            inStream = new FileInputStream(inFileName);
        }catch(FileNotFoundException e){
            System.err.println("Input File " + inFileName + " not found");
            System.exit(-1);
        }

        // assign scanner to read input file stream
        inFile = new Scanner(inStream);

        // creates output file stream or -1 if no such file
        try{
            outStream = new FileOutputStream(outFileName);
        }catch(FileNotFoundException e){
            System.err.println("Output File " + outFileName + " not found");
            System.exit(-1);
        }

        // writes to file
        outFile = new PrintWriter(outStream);

        // print in file line by line
        while(inFile.hasNextLine()){
            String s = inFile.nextLine();
            outFile.println(s);
        }

        // closes file buffers
        inFile.close();
        outFile.close();

        // --- //

        // ??? again? to restart I guess
        inFile = new Scanner(new FileInputStream(inFileName));
        int numInts=0;
        int numDoubles=0;
        int numStrings=0;

        // counts ints, doubles, strings
        while(inFile.hasNext()) {
            if (inFile.hasNextInt()) {
                int i = inFile.nextInt();
                numInts++;
            } else if (inFile.hasNextDouble()) {
                double d = inFile.nextDouble();
                numDoubles++;
            } else {
                String s = inFile.next();
                numStrings++;
            }

        }

        inFile.close();

        System.out.println("The input file "+inFileName+" has:");
        System.out.println(numInts + " ints " + numDoubles + " doubles " + numStrings + " Strings.");

    }
}