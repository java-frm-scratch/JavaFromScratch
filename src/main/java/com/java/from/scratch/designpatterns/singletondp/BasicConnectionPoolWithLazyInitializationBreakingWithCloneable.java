package com.java.from.scratch.designpatterns.singletondp;

import java.io.Serial;
import java.io.Serializable;

public class BasicConnectionPoolWithLazyInitializationBreakingWithCloneable implements Serializable , Cloneable{
    @Serial
    private static final long serialVersionUID = 1L;

    // Private static volatile instance variable
    private static volatile BasicConnectionPoolWithLazyInitializationBreakingWithCloneable INSTANCE;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // This can create a new instance
    }

    // Private constructor to prevent instantiation
    private BasicConnectionPoolWithLazyInitializationBreakingWithCloneable() {


            // Protection against reflection
            if (INSTANCE != null) {
                throw new IllegalStateException("Instance already created");
            }
        System.out.println("Creating SecureConnectionPool instance");
    }

    public static BasicConnectionPoolWithLazyInitializationBreakingWithCloneable getInstance() {
        if (INSTANCE == null) {  // First check (no locking)
            synchronized (BasicConnectionPoolWithLazyInitializationBreakingWithCloneable.class) {
                if (INSTANCE == null) {  // Second check (with locking)
                    INSTANCE = new BasicConnectionPoolWithLazyInitializationBreakingWithCloneable();
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
