/**
 * @author Khoa Tran
 * @version 07/26/2012
 * A class that detects plagiarism using the Levenhstein algorithm
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PlagiarismDetection {
	
    public static void main(String[] args) {
		
        /* Times the whole algorithm */
        StopWatch s = new StopWatch();
        s.start();
		
        /* Variables to remember the names of the files, the original input, 
         * and the desired output */
        String name, name2, input, output, output2;
        int i, j;

        /* An ArrayList of pairs that exceed the threshold for plagiarism */
        ArrayList<Pair<Pair<String, String>, Double>> pairList = new ArrayList<Pair<Pair<String, String>, Double>>();
        Pair<String, String> namePair; /* an empty name's pair for later use */
        Pair<Pair<String, String>, Double> wholePair; /* an empty pair of name's pair and a double value */
		
        /* Variables for checking Java keywords and splitting the files by whitespace */
        String [] inputArray;
        String [] keywords = {"public", "void", "private", "boolean", "true",
                              "false", "null", "abstract", "assert", "int", "double", "else",
                              "break", "byte", "case", "catch", "char", "class", "const",
                              "continue", "default", "do", "enum", "extends", "for", "finally",
                              "float", "goto", "if", "implements", "import", "instanceof",
                              "interface", "long", "native", "new", "package", "protected",
                              "return", "short", "static", "strictfp", "super", "switch",
                              "synchronized", "this", "throw", "throws", "transient", "try",
                              "volatile", "while"};

        /* Then we turn the array of keywords into a hash set for easy, O(1) access 
         * We use HashSet because we want to maintain a collection of unique values */
        List<String> wordList = Arrays.asList(keywords);
        Collection<String> wordTable = new HashSet<String>(wordList);

        /* Creates a dictionary to hold the output file, with the files' names as keys, 
         * and the output with no comments, whitespace, Java keywords as values */
        Map<String, String> outputDict = new HashMap<String, String>();
		
        /* Reads in the number of submissions needed to compare 
         * and insert the files' names into an ArrayList */
        ArrayList<String> nameList = new ArrayList<String>();
        File file = new File("files.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                nameList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /* Converts every submission into a String with no comments, 
         * whitespace, and Java keywords */
        int size = nameList.size();
        for (i = 0; i < size; i++) {

            /* Read in the files we want to compare, line by line */
            file = new File(nameList.get(i));
            name = file.getName();
            input = "";

            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    input += "\n" + scanner.nextLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            /* Removes comments - first in-line comments, next block comments, 
             * and finally JavaDoc comments */
            input = input.replaceAll("//.*", "").replaceAll("/\\*.*?\\*/","").replaceAll("/\\*\\*(?s:(?!\\*/).)*\\*/","");

            /* Splits the input file into smaller chunks by whitespace */
            inputArray = input.split("[ ]");

            /* Removes all Java keywords in the text file */
            for (int k = 0; k < inputArray.length; k++) {
                if (wordTable.contains(inputArray[k])) {
                    input = input.replaceAll(inputArray[k], "");
                }
            }

            /* Removes whitespace and tabs */
            input = input.replaceAll("\\s", ""); 
			
            /* Now inserts the output String into a dictionary for later use */
            outputDict.put(name, input);
        }
		
        /* Runs a double for loop that applies the Levenshtein algorithm on 
         * every pair of submissions, with no duplicate comparison */
        size = outputDict.size();
        for (i = 0; i < size; i++) {
			
            /* If we are at the last file, stop */
            if (i == size - 1) {
                break;
            }
			
            /* Gets the name and values of the first file to compare */
            name = nameList.get(i);
            output = outputDict.get(name);
			
            /* Compares every other files with the current file */
            for (j = i + 1; j < size; j++) {
				
                /* Gets the name and values of the second file to compare */
                name2 = nameList.get(j);
                output2 = outputDict.get(name2);
				
                /* Computes the Levenshtein distance and format it into a percentage */
                int distance = LevenshteinDistance.computeLevenshteinDistance(output, output2);
                double similarity = Math.abs((1.0 - (double)distance / 
                                              Math.max(output.length(), output2.length()))) * 100;
				
                System.out.println("Similarity between " + name + " and " + name2 + ": " + 
                                   LevenshteinDistance.format(similarity, 2) + "%");

                /* Marks any pair of files that has a similarity over 60% into an ArrayList */
                if (similarity > 60) {
                    namePair = new Pair<String, String>(name, name2);
                    wholePair = new Pair<Pair<String, String>, Double>(namePair, similarity);
                    pairList.add(wholePair);
                }
            }
        }
		
        /* Prints out all the pair(s) that exceed the threshold */
        System.out.println("\nThe pair(s) of submissions that require further investigation are: ");
        size = pairList.size();
        for (i = 0; i < size; i++) {
            wholePair = pairList.get(i);
            System.out.println(wholePair.getFirst() + ": " + 
                               LevenshteinDistance.format(wholePair.getSecond(), 2) + "%");
        }		
		
        /* Prints out how long it takes to run this algorithm on a set of assignment submissions */
        s.stop();
        System.out.println("Time elapsed: " + s.getElapsedTime() + " ms.");
    }
}

/* ---------------------- Sample Run ---------------------------
   Similarity between Lab8B_A.java and Lab8B_AwithSwaps.java: 83.95%
   Similarity between Lab8B_A.java and Lab8B_BcopyOfA.java: 100.00%
   Similarity between Lab8B_A.java and Lab8B_C.java: 35.79%
   Similarity between Lab8B_A.java and Lab8B_D.java: 42.81%
   Similarity between Lab8B_A.java and Lab8B_E.java: 50.17%
   Similarity between Lab8B_A.java and Lab8B_F.java: 30.10%
   Similarity between Lab8B_A.java and Lab8B_G.java: 53.85%
   Similarity between Lab8B_A.java and Lab8B_H.java: 45.82%
   Similarity between Lab8B_A.java and Lab8B_I.java: 33.61%
   Similarity between Lab8B_AwithSwaps.java and Lab8B_BcopyOfA.java: 83.95%
   Similarity between Lab8B_AwithSwaps.java and Lab8B_C.java: 32.11%
   Similarity between Lab8B_AwithSwaps.java and Lab8B_D.java: 40.13%
   Similarity between Lab8B_AwithSwaps.java and Lab8B_E.java: 41.81%
   Similarity between Lab8B_AwithSwaps.java and Lab8B_F.java: 29.77%
   Similarity between Lab8B_AwithSwaps.java and Lab8B_G.java: 43.81%
   Similarity between Lab8B_AwithSwaps.java and Lab8B_H.java: 41.14%
   Similarity between Lab8B_AwithSwaps.java and Lab8B_I.java: 31.13%
   Similarity between Lab8B_BcopyOfA.java and Lab8B_C.java: 35.79%
   Similarity between Lab8B_BcopyOfA.java and Lab8B_D.java: 42.81%
   Similarity between Lab8B_BcopyOfA.java and Lab8B_E.java: 50.17%
   Similarity between Lab8B_BcopyOfA.java and Lab8B_F.java: 30.10%
   Similarity between Lab8B_BcopyOfA.java and Lab8B_G.java: 53.85%
   Similarity between Lab8B_BcopyOfA.java and Lab8B_H.java: 45.82%
   Similarity between Lab8B_BcopyOfA.java and Lab8B_I.java: 33.61%
   Similarity between Lab8B_C.java and Lab8B_D.java: 42.47%
   Similarity between Lab8B_C.java and Lab8B_E.java: 40.00%
   Similarity between Lab8B_C.java and Lab8B_F.java: 48.41%
   Similarity between Lab8B_C.java and Lab8B_G.java: 41.98%
   Similarity between Lab8B_C.java and Lab8B_H.java: 69.82%
   Similarity between Lab8B_C.java and Lab8B_I.java: 27.00%
   Similarity between Lab8B_D.java and Lab8B_E.java: 54.69%
   Similarity between Lab8B_D.java and Lab8B_F.java: 31.05%
   Similarity between Lab8B_D.java and Lab8B_G.java: 52.90%
   Similarity between Lab8B_D.java and Lab8B_H.java: 50.68%
   Similarity between Lab8B_D.java and Lab8B_I.java: 31.13%
   Similarity between Lab8B_E.java and Lab8B_F.java: 36.33%
   Similarity between Lab8B_E.java and Lab8B_G.java: 60.75%
   Similarity between Lab8B_E.java and Lab8B_H.java: 53.06%
   Similarity between Lab8B_E.java and Lab8B_I.java: 33.61%
   Similarity between Lab8B_F.java and Lab8B_G.java: 31.06%
   Similarity between Lab8B_F.java and Lab8B_H.java: 45.56%
   Similarity between Lab8B_F.java and Lab8B_I.java: 23.14%
   Similarity between Lab8B_G.java and Lab8B_H.java: 51.54%
   Similarity between Lab8B_G.java and Lab8B_I.java: 35.81%
   Similarity between Lab8B_H.java and Lab8B_I.java: 30.58%

   The pair(s) of submissions that require further investigation are: 
   (Lab8B_A.java, Lab8B_AwithSwaps.java): 83.95%
   (Lab8B_A.java, Lab8B_BcopyOfA.java): 100.00%
   (Lab8B_AwithSwaps.java, Lab8B_BcopyOfA.java): 83.95%
   (Lab8B_C.java, Lab8B_H.java): 69.82%
   (Lab8B_E.java, Lab8B_G.java): 60.75%
   Time elapsed: 346 ms.
   ------------------------------------------------------------- */
