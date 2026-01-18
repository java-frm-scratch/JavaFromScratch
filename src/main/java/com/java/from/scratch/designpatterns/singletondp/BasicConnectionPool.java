package com.java.from.scratch.designpatterns.singletondp;

public class BasicConnectionPool {
    // Private static instance variable
    private static final BasicConnectionPool instance = new BasicConnectionPool();

    // Private constructor to prevent instantiation
    private BasicConnectionPool() {
        // Initialize connection pool
        System.out.println("Creating BasicConnectionPool instance");
    }

    // Public static method to get the instance
    public static BasicConnectionPool getInstance() {
        return instance;
    }

    // Example method
    public void connect() {
        System.out.println("Connected to database using BasicConnectionPool");
    }
}
