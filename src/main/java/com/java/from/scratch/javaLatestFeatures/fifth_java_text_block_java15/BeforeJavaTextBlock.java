package com.java.from.scratch.javaLatestFeatures.fifth_java_text_block_java15;

/**
 * Problems:
 *
 * Hard to read
 *
 * Lots of \n and \"
 *
 * Error-prone during changes
 */
public class BeforeJavaTextBlock {
    static void main() {

        //example 1
        String json = "{\n" +
                "  \"id\": 101,\n" +
                "  \"name\": \"JavaFromScratch\",\n" +
                "  \"role\": \"DEVELOPER\"\n" +
                "}";
        System.out.println(json);


        //example 2
        String query = "SELECT id, name, salary " +
                "FROM employee " +
                "WHERE department = ? " +
                "AND salary > ? " +
                "ORDER BY salary DESC";
        System.out.println(query);

    }

}
