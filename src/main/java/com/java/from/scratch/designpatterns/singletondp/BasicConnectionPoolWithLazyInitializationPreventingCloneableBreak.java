package com.java.from.scratch.designpatterns.singletondp;

import java.io.Serial;
import java.io.Serializable;

public class BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak implements Serializable , Cloneable{
    @Serial
    private static final long serialVersionUID = 1L;

    // Private static volatile instance variable
    private static volatile BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak INSTANCE;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton instance cannot be cloned");
    }

    // Private constructor to prevent instantiation
    private BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak() {


            // Protection against reflection
            if (INSTANCE != null) {
                throw new IllegalStateException("Instance already created");
            }
        System.out.println("Creating SecureConnectionPool instance");
    }

    public static BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak getInstance() {
        if (INSTANCE == null) {  // First check (no locking)
            synchronized (BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak.class) {
                if (INSTANCE == null) {  // Second check (with locking)
                    INSTANCE = new BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak();
                }
            }
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
