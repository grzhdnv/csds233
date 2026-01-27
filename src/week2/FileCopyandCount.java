package week2;

import java.io.*;
import java.util.Scanner;

/**
 * This program prompts a user for an input file and output file
 * It then copies the contents of the input file to the output file
 * Finally it counts the number of ints, doubles, and strings in the input file
 * and displays them to the screen (where a string is anything that is not an int or double)
 */

public class FileCopyandCount {

    public static void main(String[] args) throws IOException{
        Scanner kb = new Scanner(System.in);

        //Get the input file name from the user
        System.out.print("What's the name of the input file? ");
        String inFileName = kb.nextLine();

        //get the output file name from the user
        System.out.print("What's the name of the output file? ");
        String outFileName = kb.nextLine();


        //inFile for reading the input file
        //outFile for writing to the output file
        Scanner inFile;
        PrintWriter outFile;

        //inStream and outStream for opening the input and output files
        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        //let's make sure we can open the input file
        try{
            inStream = new FileInputStream(inFileName);
        }catch(FileNotFoundException e){
            System.err.println("Input File " + inFileName + " not found");
            System.exit(-1);
        }

        inFile = new Scanner(inStream);

        //let's make sure we can open the output file
        try{
            outStream = new FileOutputStream(outFileName);
        }catch(FileNotFoundException e){
            System.err.println("Output File " + outFileName + " not found");
            System.exit(-1);
        }

        outFile = new PrintWriter(outStream);

        //copy the input file to the output file
        while(inFile.hasNextLine()){
            String s = inFile.nextLine();
            outFile.println(s);
        }

        inFile.close();
        outFile.close();

        //now let's run back through the input file and do some counting

        inFile = new Scanner(new FileInputStream(inFileName));
        int numInts=0;
        int numDoubles=0;
        int numStrings=0;

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
