package com.java.from.scratch.javaLatestFeatures.fifth_java_text_block_java15;

/**
 * Looks exactly like JSON
 * ✔ No escaping
 * ✔ Easy to modify
 */
public class AfterJavaTextblock {
    static void main() {
        String json = """
                
                {
                "id": 101,
                "name": "JavaFromScratch",
                "role": "DEVELOPER"
                "address": "India"
                }
                
                
                """;

        System.out.println(json);

        //example 2
        String query = """
        SELECT id, name, salary
        FROM employee
        WHERE department = ?
          AND salary > ?
        ORDER BY salary DESC
        """;
        System.out.println(query);

    }
}
