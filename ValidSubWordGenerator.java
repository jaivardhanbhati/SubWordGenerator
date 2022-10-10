package SubWordGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ValidSubWordGenerator {
    static Set<String> dictionary = new HashSet<String>();
    static List<String> validWords = new ArrayList<String>();
    static String output = "";

    public static boolean validateWord(String word) {
        
        if(word.length() == 1) {
            return true;
        }

        if(dictionary.contains(word.trim().toUpperCase())) {
            validWords.add(word);
        } 

        if(!dictionary.contains(word.trim().toUpperCase())) {
            return false;
        }
            
        for(int i=0;i<word.length();i++) {
            String choppedWord = removeCharAt(word,i);
            boolean result = validateWord(choppedWord);
            if(result) {
                validWords.add(choppedWord);
                int index = 0;
                for(String s: validWords) {
                    if(index == 0)
                    output += s + " ";
                    else 
                    output += " => " + s;
                    index ++;
                }
                System.out.println(output);
                output = "";
                return true;
            } 

        }
        return false;
    }

    public static String removeCharAt(String str, Integer n) {
        String f = str.substring(0, n);
        String b = str.substring(n+1, str.length());
        return f + b;
    }

    public static void loadEnglishDictionary() {
        

        try {
            // load data from file
        BufferedReader bf = new BufferedReader(
            new FileReader("EnglishDictionary.txt") );
       
        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            dictionary.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();
        } catch (IOException e) {
            // TODO: handle exception
        }   
    }


    public static void main(String args[]){
    
        loadEnglishDictionary();

        System.out.println("Enter the word without spaces which you'd like to find subwords from: ");
        String input = System.console().readLine();
        System.out.println("Calculating all the subwords within " + input);
        validateWord(input);
        System.out.println(validWords);

    }

}