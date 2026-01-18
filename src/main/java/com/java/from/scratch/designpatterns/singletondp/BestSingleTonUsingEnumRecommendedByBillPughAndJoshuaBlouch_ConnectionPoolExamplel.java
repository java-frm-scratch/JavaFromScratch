package com.java.from.scratch.designpatterns.singletondp;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum singleton - The most secure way to implement Singleton in Java
 * Handles serialization and reflection attacks automatically
 */
public enum BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel implements Cloneable{
    INSTANCE;

    // Connection pool related methods
    private final ConnectionPool connectionPool;

    // Enum constructors are private by default
    private BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel() {
        // Initialize connection pool
        this.connectionPool = new ConnectionPool();
        System.out.println("EnumConnectionPool instance created");
    }



    public Connection getConnection() {
        return connectionPool.getConnection();
    }

    public void releaseConnection(Connection connection) {
        connectionPool.releaseConnection(connection);
    }

    // Nested class representing the actual connection pool
    private static class ConnectionPool {
        private final List<Connection> connectionPool;
        private final int MAX_POOL_SIZE = 10;

        public ConnectionPool() {
            // Initialize pool with connections
            connectionPool = new ArrayList<>(MAX_POOL_SIZE);
            for (int i = 0; i < MAX_POOL_SIZE; i++) {
                connectionPool.add(createConnection());
            }
        }

        private Connection createConnection() {
            // Create and return a new connection
            // In real world, this would create a database connection
            return new Connection();
        }

        public synchronized Connection getConnection() {
            // Get an available connection
            for (Connection conn : connectionPool) {
                if (!conn.isInUse()) {
                    conn.setInUse(true);
                    return conn;
                }
            }
            // If no connection is available, wait or throw exception
            throw new RuntimeException("No available connections in the pool");
        }

        public synchronized void releaseConnection(Connection connection) {
            connection.setInUse(false);
        }
    }

    // not needed you will get compile time error
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }*/
}