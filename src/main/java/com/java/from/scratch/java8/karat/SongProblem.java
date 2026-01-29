package com.java.from.scratch.java8.karat;

import java.util.ArrayList;
import java.util.List;

public class SongProblem {

    public static void main(String[] args) {
        List<String> list = List.of("Love story","Story of my life","life goes on",
        "on my way","way back home");

        String initialWord = "crazy love";
        // traverse through the list and starting from the
        // initialWord, find the song that starts with the last word of the initialWord
        // and continue this process until you find a song that starts with the last word of the previous song
        // return the list of songs in the order they are found
        //and return the list of songs in the order they are found
        // and find the longest possible chain of songs


        //List<String> longestChain = findLongestChain(list, initialWord);
        //System.out.println(longestChain);


        String numberStr = "12345";
        long number = Long.parseLong(numberStr);
        System.out.println(number);

    }

    private static List<String> findLongestChain(List<String> list, String initialWord) {
    //1) convert all songs to lowercase for case insensetive comparision
        //2)// Get the starting word (last word of initial phrase)
        //        String startWord = getLastWord(initialWord.toLowerCase());
        List<String> songList=list.stream().map(String::toLowerCase).toList();
        List<String> result = new ArrayList<>();
        String startWord = getLastWord(initialWord.toLowerCase());
        System.out.println("Last word from initial song is: "+startWord);
        result.add(initialWord);
        String nextStartWord = startWord;

        for(String s: songList){

            if(s.startsWith(nextStartWord)){
                nextStartWord = getLastWord(s.toLowerCase());
                System.out.println("Subsequent next word is: "+nextStartWord);
                System.out.println("the song is:"+s);
                result.add(s);
            }
       }

        System.out.println(result);

        return result;
    }

    static String getLastWord(String word){
        return word.split(" ")[word.split(" ").length-1];
    }
}
