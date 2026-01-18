package com.java.from.scratch.designpatterns.singletondp;

import java.io.Serializable;

public class BasicConnectionPoolWithReflectionBreakResolved {
    // Private static instance variable
    private static final BasicConnectionPoolWithReflectionBreakResolved INSTANCE = new BasicConnectionPoolWithReflectionBreakResolved();


    // flag to track object creation
    private static boolean isInstanceCreated = false;

    // Private constructor to prevent instantiation
    private BasicConnectionPoolWithReflectionBreakResolved() {

        // Protection against reflection
        if (INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        System.out.println("Creating SecureConnectionPool instance");
    }

    // Public static method to get the instance
    public static BasicConnectionPoolWithReflectionBreakResolved getInstance() {
        return INSTANCE;
    }

    // Example method
    public void connect() {
        System.out.println("Connected to database using BasicConnectionPool");
    }
}
