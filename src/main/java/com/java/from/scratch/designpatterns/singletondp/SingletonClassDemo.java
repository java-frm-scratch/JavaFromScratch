package com.java.from.scratch.designpatterns.singletondp;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class SingletonClassDemo {

    public static void main(String[] args) {

        //1)  creating 2 instances should retun same hashcode but it is retuning different hashcode
        /*SingletonClassDemo singletonClassDemo1 = new SingletonClassDemo();
        SingletonClassDemo singletonClassDemo2 = new SingletonClassDemo();

        System.out.println(singletonClassDemo1);
        System.out.println(singletonClassDemo2);*/

        /// ///////////////////////////////////////////////////////////////////


        //2) create a basic singleton using eager initialization ..
        //2.1 not able to access the constructor so first objective is achieved
        //BasicConnectionPool basicConnectionPool = new BasicConnectionPool(); //not able to create the object since constructor is private

        //2.2 giving same hashcode ,so second objective  achieved
        /*BasicConnectionPool instance1 = BasicConnectionPool.getInstance();
        BasicConnectionPool instance2 = BasicConnectionPool.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);*/


        //2.3 we can break this using reflection api
        //breakUsingReflection();

        //2.4 reflection break resolved inside BasicConnectionPoolWithReflectionBreakResolved
        // basically in order to prefvent reflection break, we add instance!=null inside Constructor
        //breakUsingReflectionTest();

        //2.5 we can still break using serialization and deserialization
        //breakWithSerialization();

        //2.6 we can resolve seralization and deserialization break using readResolve method
        // all mentioned here: BasicConnectionPoolWithSerializationBreakResolved



       // 3) create a SingleTon class using Lazy initialization
        // all details mentioned here : BasicConnectionPoolWithLazyInitialization
        // 2.7 breaking singleton class using lazy initialization using threads
        //breakLazyInitializedSingletonUsingMultiThreadedEnv();


        //3.1 preventing lazy initialization break by making whole
        // getInstance method synchronized
        // as mentioned here : BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized
       // tryTobreakLazyInitializedSingletonWholeGetInstanceMethodSynchronized();
        //making whole getInstance method as synchronized is nt a good idea and good practice because of below reasons
       /*
        Performance Overhead:
        Every call to getInstance() acquires and releases a lock, even after the instance is created
        This can create a significant bottleneck in high-concurrency scenarios
        Most calls only need to read the instance, not create it
        Unnecessary Synchronization:
        After the first call, the instance exists and won't change
        Synchronization is only needed during the first call when creating the instance
        Subsequent calls don't need synchronization but still pay the performance cost
        */

        //3.2 Double-checked locking (with volatile)
        // as mentioned here : BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile
        //tryTobreakLazyInitializedSingletonwithDoubleCheckedLocking();

        //3.3 you can still break singleton class
        // if singleton class is implementing clone method
        // and overriding the cone method like below
       /* @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();  // This can create a new instance
        }*/
        //breakSingletonWithClone();

        //3.4 preventing to break with clone
        // here , to prevent clone and create seperate instances, you need to throw CloneNotSupportedException from overrirden method inside singleTon class like below
        /*@Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Singleton cannot be cloned");
        }*/
        //mentioned here : BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak
       // preventBreakSingletonWithClone();





        //4. best singleton recommended  by Joshua Bloch is enum singleton
        // details can be found here :
        testBestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel();



    }

    private static void preventBreakSingletonWithClone() {
        try {
            // Get the singleton instance
            BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak instance1 =
                    BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak.getInstance();

            // Create a clone of the singleton
            BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak instance2 =
                    (BasicConnectionPoolWithLazyInitializationPreventingCloneableBreak) instance1.clone();

            // Print hash codes
            System.out.println("Instance 1 hash: " + System.identityHashCode(instance1));
            System.out.println("Instance 2 hash: " + System.identityHashCode(instance2));
            System.out.println("Are instances same? " + (instance1 == instance2));

        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void breakSingletonWithClone() {
        try {
            // Get the singleton instance
            BasicConnectionPoolWithLazyInitializationBreakingWithCloneable instance1 =
                    BasicConnectionPoolWithLazyInitializationBreakingWithCloneable.getInstance();

            // Create a clone of the singleton
            BasicConnectionPoolWithLazyInitializationBreakingWithCloneable instance2 =
                    (BasicConnectionPoolWithLazyInitializationBreakingWithCloneable) instance1.clone();

            // Print hash codes
            System.out.println("Instance 1 hash: " + System.identityHashCode(instance1));
            System.out.println("Instance 2 hash: " + System.identityHashCode(instance2));
            System.out.println("Are instances same? " + (instance1 == instance2));

        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void tryTobreakLazyInitializedSingletonwithDoubleCheckedLocking() {

        int numberOfThreads = 10;
        Set<BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile> instances =
                Collections.synchronizedSet(new HashSet<>());

        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                try {
                    // All threads will try to get the instance at the same time
                    BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile instance =
                            BasicConnectionPoolWithLazyInitializationDoubleCheckEdLockingUsingVolatile.getInstance();
                    instances.add(instance);
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " got instance with hash: " +
                            System.identityHashCode(instance));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await(); // Wait for all threads to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print all unique instances
        System.out.println("\n=== Unique Instances ===");
        instances.forEach(instance ->
                System.out.println("Instance hash: " + System.identityHashCode(instance))
        );

        System.out.println("\nNumber of unique instances created: " + instances.size());

        if (instances.size() > 1) {
            System.out.println("\n Singleton pattern broken! Multiple instances were created.");
        } else {
            System.out.println("\n Singleton pattern maintained. Only one instance was created.");
        }

    }

    private static void testBestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel() {
        // Get multiple instances
        BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel instance1 =
                BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel.INSTANCE;
        BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel instance2 =
                BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel.INSTANCE;

        // Print hash codes to verify they're the same instance
        System.out.println("Instance 1 hash: " + System.identityHashCode(instance1));
        System.out.println("Instance 2 hash: " + System.identityHashCode(instance2));
        System.out.println("Are instances same? " + (instance1 == instance2));

        try {
            // Test connection pool functionality
            System.out.println("\nTesting connection pool:");
            Connection connection = instance1.getConnection();
            System.out.println("Connection hash: " + System.identityHashCode(connection));

            try {
                connection.executeQuery("SELECT * FROM users");
            } finally {
                instance1.releaseConnection(connection);
            }

            // Try to break it with reflection (won't work)
            System.out.println("\nTrying reflection attack...");
            try {
                Constructor<?>[] constructors = BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel.class.getDeclaredConstructors();
                for (Constructor<?> constructor : constructors) {
                    constructor.setAccessible(true);
                    // This will throw IllegalArgumentException
                    BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel brokenInstance =
                            (BestSingleTonUsingEnumRecommendedByBillPughAndJoshuaBlouch_ConnectionPoolExamplel) constructor.newInstance();
                }
            } catch (Exception e) {
                System.out.println("✅ Reflection attack prevented: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Tests if a singleton implementation is thread-safe by creating multiple threads
     * that try to get the singleton instance simultaneously.
     *
     * <p>How it works:
     * 1. Creates multiple threads (10 by default)
     * 2. Each thread tries to get the singleton instance
     * 3. Stores all obtained instances in a synchronized set
     * 4. After all threads complete, checks if only one unique instance was created
     *
     * <p>What to look for in the output:
     * - If multiple unique hash codes appear, the singleton is not thread-safe
     * - If only one unique hash code appears, the singleton is thread-safe
     *
     * <p>Why this is important:
     * - In a multi-threaded environment, race conditions can cause multiple instances
     *   to be created if the singleton implementation is not properly synchronized
     * - This test helps verify if the singleton can maintain its single-instance
     *   guarantee under concurrent access
     *
     * <p>Note: The test uses CountDownLatch to ensure all threads start at approximately
     * the same time, increasing the chance of catching thread-safety issues.
     */
    private static void breakLazyInitializedSingletonUsingMultiThreadedEnv() {

            int numberOfThreads = 10;
            Set<BasicConnectionPoolWithLazyInitialization> instances =
                    Collections.synchronizedSet(new HashSet<>());

            CountDownLatch latch = new CountDownLatch(numberOfThreads);

            for (int i = 0; i < numberOfThreads; i++) {
                new Thread(() -> {
                    try {
                        // All threads will try to get the instance at the same time
                        BasicConnectionPoolWithLazyInitialization instance =
                                BasicConnectionPoolWithLazyInitialization.getInstance();
                        instances.add(instance);
                        System.out.println("Thread " + Thread.currentThread().getId() +
                                " got instance with hash: " +
                                System.identityHashCode(instance));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }).start();
            }

            try {
                latch.await(); // Wait for all threads to complete
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Print all unique instances
            System.out.println("\n=== Unique Instances ===");
            instances.forEach(instance ->
                    System.out.println("Instance hash: " + System.identityHashCode(instance))
            );

            System.out.println("\nNumber of unique instances created: " + instances.size());

            if (instances.size() > 1) {
                System.out.println("\n Singleton pattern broken! Multiple instances were created.");
            } else {
                System.out.println("\n Singleton pattern maintained. Only one instance was created.");
            }

    }

    /**
     * Tests if a singleton implementation is thread-safe by creating multiple threads
     * that try to get the singleton instance simultaneously.
     *
     * <p>How it works:
     * 1. Creates multiple threads (10 by default)
     * 2. Each thread tries to get the singleton instance
     * 3. Stores all obtained instances in a synchronized set
     * 4. After all threads complete, checks if only one unique instance was created
     *
     * <p>What to look for in the output:
     * - If multiple unique hash codes appear, the singleton is not thread-safe
     * - If only one unique hash code appears, the singleton is thread-safe
     *
     * <p>Why this is important:
     * - In a multi-threaded environment, race conditions can cause multiple instances
     *   to be created if the singleton implementation is not properly synchronized
     * - This test helps verify if the singleton can maintain its single-instance
     *   guarantee under concurrent access
     *
     * <p>Note: The test uses CountDownLatch to ensure all threads start at approximately
     * the same time, increasing the chance of catching thread-safety issues.
     */
    private static void tryTobreakLazyInitializedSingletonWholeGetInstanceMethodSynchronized() {

        int numberOfThreads = 10;
        Set<BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized> instances =
                Collections.synchronizedSet(new HashSet<>());

        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                try {
                    // All threads will try to get the instance at the same time
                    BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized instance =
                            BasicConnectionPoolWithLazyInitializationMakeWholeGetInstanceMethodSynchronized.getInstance();
                    instances.add(instance);
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " got instance with hash: " +
                            System.identityHashCode(instance));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await(); // Wait for all threads to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print all unique instances
        System.out.println("\n=== Unique Instances ===");
        instances.forEach(instance ->
                System.out.println("Instance hash: " + System.identityHashCode(instance))
        );

        System.out.println("\nNumber of unique instances created: " + instances.size());

        if (instances.size() > 1) {
            System.out.println("\n Singleton pattern broken! Multiple instances were created.");
        } else {
            System.out.println("\n Singleton pattern maintained. Only one instance was created.");
        }

    }

    /**
     * Demonstrates how serialization can break the singleton pattern.
     *
     * <p>Steps to break singleton using serialization:
     * <ol>
     *   <li>We get the singleton instance using getInstance() and store its hash code.</li>
     *   <li>We serialize this instance to a file using ObjectOutputStream.
     *       - This writes the object's state to a byte stream.</li>
     *   <li>We then deserialize it back into a new object using ObjectInputStream.
     *       - This creates a new instance by reading the object's state from the byte stream.
     *       - The JVM doesn't use the constructor; instead, it creates a new instance using reflection.</li>
     *   <li>We compare the original and deserialized instances.
     *       - If the singleton pattern is broken, they will be different objects (different hash codes).
     *       - This happens because deserialization creates a new instance instead of returning the existing one.</li>
     * </ol>
     *
     * <p>Why this breaks the singleton:
     * - During deserialization, Java creates a new instance of the class without calling the constructor.
     * - The readObject() method of ObjectInputStream creates a new instance using reflection.
     * - This bypasses our singleton's private constructor and instance control.
     *
     * <p>How to fix this:
     * - Implement the readResolve() method in the singleton class to return the existing instance.
     * - The readResolve() method is called by the JVM during deserialization.
     * - By returning the existing instance, we ensure that only one instance exists.
     *
     * @see java.io.Serializable
     * @see java.io.ObjectInputStream#readObject()
     * @see java.io.ObjectOutputStream#writeObject(Object)
     */
    private static void breakWithSerialization() {
        try {
            // Get the singleton instance
            BasicConnectionPoolWithSerializationBreakResolved instance1 =
                    BasicConnectionPoolWithSerializationBreakResolved.getInstance();

            // Serialize the instance to a file
            try (ObjectOutput out = new ObjectOutputStream(
                    new FileOutputStream("singleton.ser"))) {
                out.writeObject(instance1);
            }

            // Deserialize it back into a new object
            try (ObjectInput in = new ObjectInputStream(
                    new FileInputStream("singleton.ser"))) {
                BasicConnectionPoolWithSerializationBreakResolved instance2 =
                        (BasicConnectionPoolWithSerializationBreakResolved) in.readObject();

                // Print hash codes to check if they're the same instance
                System.out.println("instance1 hash: " + instance1.hashCode());
                System.out.println("instance2 hash: " + instance2.hashCode());
                System.out.println("Are instances same? " + (instance1 == instance2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void breakUsingReflection() {
        try {
            BasicConnectionPool instance1 = BasicConnectionPool.getInstance();

            // Using reflection to break singleton
            Constructor<BasicConnectionPool> constructor =
                    BasicConnectionPool.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            BasicConnectionPool instance2 = constructor.newInstance();

            System.out.println("instance1 hash: " + instance1.hashCode());
            System.out.println("instance2 hash: " + instance2.hashCode());
            System.out.println("Are instances same? " + (instance1 == instance2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void breakUsingReflectionTest() {
        try {
            BasicConnectionPoolWithReflectionBreakResolved instance1 = BasicConnectionPoolWithReflectionBreakResolved.getInstance();

            // Using reflection to break singleton
            Constructor<BasicConnectionPoolWithReflectionBreakResolved> constructor =
                    BasicConnectionPoolWithReflectionBreakResolved.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            BasicConnectionPoolWithReflectionBreakResolved instance2 = constructor.newInstance();

            System.out.println("instance1 hash: " + instance1.hashCode());
            System.out.println("instance2 hash: " + instance2.hashCode());
            System.out.println("Are instances same? " + (instance1 == instance2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void breakLazySingleTonUsingReflectionTest() {
        try {
            BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass instance1 = BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass.getInstance();

            // Using reflection to break singleton
            Constructor<BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass> constructor =
                    BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            BasicConnectionPoolWithLazyInitializationWithBillPughMethodUsingHolderStaticInnerClass instance2 = constructor.newInstance();

            System.out.println("instance1 hash: " + instance1.hashCode());
            System.out.println("instance2 hash: " + instance2.hashCode());
            System.out.println("Are instances same? " + (instance1 == instance2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
