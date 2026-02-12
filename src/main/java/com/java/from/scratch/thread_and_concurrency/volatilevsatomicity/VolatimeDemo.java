package com.java.from.scratch.thread_and_concurrency.volatilevsatomicity;

/**
 * What SHOULD happen?
 *
 * After 2 seconds:
 *
 * Server started...
 * Server stopped...
 *
 * What ACTUALLY may happen?
 * Server started...
 *
 *
 * ⚠️ Program never stops
 *
 * WHY this happens? (Very important)
 * Step-by-step execution
 *
 * t1 reads running = true
 *
 * JVM stores running in CPU cache
 *
 * t1 keeps checking cached value (true)
 *
 * t2 changes running = false in main memory
 *
 * t1 never re-reads main memory
 *
 * Infinite loop ❌
 *
 */
public class VolatimeDemo {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();

        Thread t1 = new Thread(server::startServer);
        t1.start();

        Thread.sleep(2000); // wait for 2 seconds

        Thread t2 = new Thread(server::stopServer);
        t2.start();
    }
}

/**


 - we have a server --- its running , state
 and after some time (after 2 seconds)server should stop , that is our requirement ....
 but
 what wiill if we dont use volatile, .. our server will never stop .. and it will go in
 infinite loop.

 and server will not stop ...

 solution: use volatile for variable
 private volatile boolean running = true;

 if you use volatile for variable , then t2 thread will write / make change in main memory
 and t1 thread will read from main memory instead of CPU cache.
 and t1 will get updated value always !!!!




 */
class Server {
    private volatile boolean running = true;// lets aassume that server is always running, we will stop it seperately

    public void startServer() {
        System.out.println("Server started...");
        while (running) {//t1 reads running = true,--> JVM stores running in CPU cache -->t1 keeps checking cached value (true)
            // server is running
        }
        System.out.println("Server stopped...");
    }

    public void stopServer() {
        running = false;//t2 changes running = false in main memory
    }
}