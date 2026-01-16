package com.java.from.scratch.interview.questions.hashmapInternalWorking;

import java.util.*;

public class HashMapInternalWorkingDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(3);
        map.put(1,"Java");
        map.put(5,"scratch");
        map.put(10,"javaValue");
        map.put(null,"xyz");

       // map.put(null,"python");
        //map.put(11,null);
       // map.put(null,"cpp");

       // System.out.println(map.size());//2
        System.out.println(map.get(null)); //caluclate the hash of the key
        /**
         * here , key sis 1 -- so it will calculate the hash for this key 1
         * thos hash should be the smae as the hash of the key that is stored in the map
         * so it will return the value associated with the key 1
         *
         */

        /*for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }*/

       //Hashtable<Integer, String> hashtable = new Hashtable<>();
        //hashtable.put(null,"abc");
        //System.out.println(hashtable.get(null)); //

        //SortedMap sortedMap;
       // TreeMap treeMap;




    }
}
