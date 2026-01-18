package com.java.from.scratch.designpatterns.singletondp;

import java.io.Serial;
import java.io.Serializable;

public class BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // Private static instance variable
    private static BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized INSTANCE;


    // Private constructor to prevent instantiation
    private BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized() {


            // Protection against reflection
            if (INSTANCE != null) {
                throw new IllegalStateException("Instance already created");
            }
        System.out.println("Creating SecureConnectionPool instance");
    }

    // Public static method to get the instance
    public static synchronized BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized();
        }
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
