package com.java.from.scratch.designpatterns.singletondp;

import java.io.Serial;
import java.io.Serializable;

public class BasicConnectionPoolWithLazyInitialization implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // Private static instance variable
    private static BasicConnectionPoolWithLazyInitialization INSTANCE;


    // Private constructor to prevent instantiation
    private BasicConnectionPoolWithLazyInitialization() {


            // Protection against reflection
            if (INSTANCE != null) {
                throw new IllegalStateException("Instance already created");
            }
        System.out.println("Creating SecureConnectionPool instance");
    }

    // Public static method to get the instance
    public static BasicConnectionPoolWithLazyInitialization getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BasicConnectionPoolWithLazyInitialization();
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
