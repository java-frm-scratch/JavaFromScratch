package com.java.from.scratch.designpatterns.singletondp;

import java.io.Serial;
import java.io.Serializable;

public class BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private static class Holder {
        static final BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass INSTANCE =
                new BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass();
    }

    // Private constructor to prevent instantiation
    private BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass() {

        // Protection against reflection
        if (Holder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        System.out.println("Creating SecureConnectionPool instance");
    }

    // Public static method to get the instance
    public static synchronized BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass getInstance() {
        return Holder.INSTANCE;
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
