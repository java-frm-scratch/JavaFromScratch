=====================================================
Interview Question 1)
What is hierarchy of java collections?
Collection(interface)
|
List(interface)
|
ArrayList(class)
=====================================================
Interview Question 2)
when can we go with array and when can we go with arraylist?
Ans:
- if we know the size array is fixed then we can go with array
- if we don't know the size of the array at the time of declaration then we can go with arraylist
- if you dont know the size is fixed or not then go with Collection
=====================================================
Interview Question 3)
Why we need generics ?
- generics are there from 1.5 version
- (from java 1.7 and above,),
no need to give data type both the sides  at right side you need to give <> diamond symbol
Ans:
- we need generics if we want to store only similar type of data in collection
eg Collection<Integer> values = new ArrayList();
so here , only integers are allowed
=====================================================
Interview Question 4)
can we add element in between if we use Collection interface?
Ans:
- we can't add element in between if we use Collection interface
- for adding element in between , instead of Colelction interface,
- we should use List interface, List internally uses Collection interface
- List interface extends Collection interface
=====================================================
- Q: How does System.out.println(map) print all values without iteration?
  A:
  Java internally calls the toString() method of HashMap, 
- which iterates over the map’s entries using entrySet()
- and builds a formatted string. 
- The iteration is hidden from the user through abstraction.
=====================================================
- Q: Is set ordered?
- A: No, set is not ordered
- the order you insert elements, you will not get in the same order
- in order to maintain order we should use linkedhashset
=====================================================
- Q:is Treeset ordered?
- A: Yes, Treeset is ordered
- it will maintain order(treeset is by default sorted)
============================================================
Q) What is functionalInterface?
- Ans: 
- A functional interface is having only 1 public abstract method
- @Functionalinterface is an annotation we can use at the top of this interfac
- this is optional annotation , but better to add to follow rules
============================================================
- Q) what is thread? why we need it?
- ans: 
- lets say you want to do some job in parallel, then you can create threads 
- if you want to execute multiple tasks at the same time then threads are  useful
============================================================
- Q) what is race condition in threads?and how to prevent it?
when 2 or more threads try to acces the shared resource, then race 
condition can occur, we can prevent race condition by using synchronized 
method. this we can apply to method or block.
- lets say you have 1 bank account and and lets say you have 2 cards 
- lets say you have 1 card , and you go to 2 diffeent ATM machines 
- and both of you at the same time, trying to withdraw money 
- and lets say balance is 1000 and both are trying to withdraw 1000 rs 
============================================================
- Q) what are join methods? why we need?
Ans: using join() --> join is special method which allowes 
your main thread to wait till the actual executing threads comeback and join 
Exmaple: 
- lets say , we have 2 threads, and they are doing some job 
- and both the threads are staretd from main using t1.start() and t2.start()
- and in main , after starting these 2 threads, we are just printing the resut lets say 
- so we can tell main thread, let t1 and t2 comeback to you, 
let t1 and t2 complete their work by doing the jobs 
and when both comes back, then print the result 
so how to say main to wait fort1 and t2? ans is using join methods 
t1.join();
t2.join();
===============================================================
- Q) what will happen if 2 threads use same variable?/ or shared variable?
Ans: 
if 2 or more threads are accessing shared resource, at the same time, then 
issue can occur
- example, lets say both threads are incrementing count variable 
- and lets say both threads at the same time reaches counter variable 
at the same time , they both got the value lets say 10,
then they both will say 10+1 = 11
but , here we got 2 iterations (we called increment 2 times, but increment
happened only once )
that can happen if 2 or more threads uses same shared variable
How to prevent 2 or more threads using the single resource at the same time?
Ans: we can make method "synchronized" who is incrementing the value
java will make sure this method will be get called by only 1 thread at a time 
if t1 is making an increment, t2 has to wait 

=================================================================
- Q) what are different states of a thread?
ans 
- New state: when we create a thread, then its in in new state eg: Thread t1 = new Thread();
- runnable state: the moment we do t1.start() it will go to runnable state(here , actually thread is waiting 
- for scheduler)
-Running state: thread is running with the help of run()
- waiting state: --> lets  say you want to hold it using sleep(), or wait(), 
when you do wait(), then you need to notify() to come back 
when you do notify(), then thread will come to Runnable state again 
and whenever scheduler is available again, then it will go to runnig state
- Dead satte: if thread is running, and you wnat to stop it, then 
you can call stop() then it wil stop and go to dead state
(note: stop() is depricated, dont stop threads it will create 
instebility in your software)
- 
- 
- 
- 