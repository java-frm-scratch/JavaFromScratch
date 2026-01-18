package com.java.from.scratch.designpatterns.singletondp;

import java.io.Serial;
import java.io.Serializable;

public class BasicConnectionPoolWithSerializationBreakResolved implements Serializable {
    // Private static instance variable
    private static final BasicConnectionPoolWithSerializationBreakResolved INSTANCE = new BasicConnectionPoolWithSerializationBreakResolved();


    // flag to track object creation
    private static boolean isInstanceCreated = false;

    // Private constructor to prevent instantiation
    private BasicConnectionPoolWithSerializationBreakResolved() {

        // Protection against reflection
        if (INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        System.out.println("Creating SecureConnectionPool instance");
    }

    // Public static method to get the instance
    public static BasicConnectionPoolWithSerializationBreakResolved getInstance() {
        return INSTANCE;
    }

    // This method is called during deserialization
    @Serial
    protected Object readResolve() {
        return getInstance();  // Always return the existing instance
    }

    // Example method
    public void connect() {
        System.out.println("Connected to database using BasicConnectionPool");
    }
}
