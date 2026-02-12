package com.java.from.scratch.collection_learning;

import com.java.from.scratch.java8.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

/**
 for arraylist size is not fixed, it can grow and shrink

 */
public class CollectionDemo {
    static void main() {
        // if we use generics, then we can store only similar type of data,
        // since this is Integer colelction, we can store only integers, Not strings
        Collection<Integer> values = new ArrayList();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.remove(3);
        System.out.println("Collection values : "+values);
       // values.add("hello");// not allowed



        // add element in specified index
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(1,4);
        System.out.println("element is added in index 1"+list);





        // what will happen if we print the map directly
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        map.put("ten",10);
        System.out.println("HashMap--> it will not maintain order"+map);

        // if you want to maintain order, then use LinkedHashMap

        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("one",1);
        linkedHashMap.put("two",2);
        linkedHashMap.put("three",3);
        linkedHashMap.put("four",4);
        linkedHashMap.put("five",5);
        linkedHashMap.put("six",6);
        linkedHashMap.put("seven",7);
        linkedHashMap.put("eight",8);
        linkedHashMap.put("nine",9);
        linkedHashMap.put("ten",10);
        System.out.println("LinkedHashMap--> it will maintain order"+linkedHashMap);


        // Set dont maintain order
        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        set.add("six");
        set.add("seven");
        set.add("eight");
        set.add("nine");
        set.add("ten");


        System.out.println("HashSet--> it will not maintain order"+set);

        // in order to maintain order, we should use LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("one");
        linkedHashSet.add("two");
        linkedHashSet.add("three");
        linkedHashSet.add("four");
        linkedHashSet.add("five");
        linkedHashSet.add("six");
        linkedHashSet.add("seven");
        linkedHashSet.add("eight");
        linkedHashSet.add("nine");
        linkedHashSet.add("ten");
        System.out.println("LinkeeHashset:it will maintain order "+linkedHashSet);


        //Treeset is by default sorted
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(4);
        treeSet.add(3);
        treeSet.add(2);
        System.out.println("TreeSet--> it will maintain order(treeset is by default sorted)"+treeSet);


        //
        String s1="hello";
        String s2 = "hello";
        Set<String> strings = new HashSet<>();
        strings.add(s1);
        strings.add(s2);
        System.out.println("size is:"+strings.size());// size will be 1
        //
        String s3 = new String("hello");
        String s4 = new String("hello");
        Set<String> stringSet = new HashSet<>();
        stringSet.add(s3);
        stringSet.add(s4);
        System.out.println("Size is : "+stringSet.size());


        EmployeeData employeeData1 = new EmployeeData(1,"amol");
        EmployeeData employeeData2 = new EmployeeData(1,"amol");

        Set<EmployeeData> employeeData = new HashSet<>();
        employeeData.add(employeeData1);
        employeeData.add(employeeData2);
        System.out.println("Size of custom employee class set is: "+employeeData.size());

    }
}
//@
@EqualsAndHashCode
@AllArgsConstructor
class EmployeeData{
    int id;
    String name;
}