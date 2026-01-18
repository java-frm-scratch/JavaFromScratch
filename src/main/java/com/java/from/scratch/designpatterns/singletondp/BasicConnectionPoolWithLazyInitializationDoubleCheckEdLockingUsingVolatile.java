package com.java.from.scratch.designpatterns.singletondp;

import java.io.Serial;
import java.io.Serializable;

public class BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // Private static volatile instance variable
    private static volatile BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile INSTANCE;


    // Private constructor to prevent instantiation
    private BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile() {


            // Protection against reflection
            if (INSTANCE != null) {
                throw new IllegalStateException("Instance already created");
            }
        System.out.println("Creating SecureConnectionPool instance");
    }

    public static BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile getInstance() {
        if (INSTANCE == null) {  // First check (no locking)
            synchronized (BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile.class) {
                if (INSTANCE == null) {  // Second check (with locking)
                    INSTANCE = new BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile();
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
