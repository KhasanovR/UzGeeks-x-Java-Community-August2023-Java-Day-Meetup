# Threads in Java

## What is a Thread?

A thread is the smallest unit of a process that can execute concurrently. In Java, threads are objects that represent a separate path of execution within a program.

## Why do we use Threads?

Threads are useful when you want to perform multiple tasks simultaneously, such as running computations, handling user interactions, or performing I/O operations. By using threads, you can make your application more efficient and responsive.

## Creating Threads in Java:

To create threads in Java, you have two main approaches:
- Extending the `Thread` class.
- Implementing the `Runnable` interface (recommended as it allows better class design). 

**Step-by-step Example using Runnable:**

Let's create a simple Java program to demonstrate the creation and execution of threads using the `Runnable` interface:

**Step 1:** Create a new Java class called `ThreadExample`.

**Step 2:** Implement the `Runnable` interface in the `ThreadExample` class.

```java
public class ThreadExample implements Runnable {
   //
   @Override
   public void run() {
       //
       for (int i = 1; i <= 5; i++) {
           System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
       }
   }
}
```

**Step 3:**  In the `main` method, create a `Thread` object and pass the `ThreadExample` instance to it.

```java
public class Main {
   //
   public static void main(String[] args) {
       //
       ThreadExample threadExample = new ThreadExample();

       Thread thread = new Thread(threadExample);

       thread.start();
   }
}
```

**Step 4:** Run the program and observe the output. You will see the numbers from 1 to 5 printed by the thread.

**Step 5:** (Optional) Add more threads by creating additional Thread objects and starting them.

```java
public class Main { 
   //
   public static void main(String[] args) {
       //
       ThreadExample threadExample = new ThreadExample();

       Thread thread1 = new Thread(threadExample);
       Thread thread2 = new Thread(threadExample);
       Thread thread3 = new Thread(threadExample);

       thread1.start();
       thread2.start();
       thread3.start();
   }
}
```

**Explanation:**

In this examples, we created a simple `ThreadExample` class implementing the `Runnable` interface. The `run()` method contains the code that will be executed when the thread starts. In the `main` method, we created a `Thread` object and passed the `ThreadExample` instance to it. When we called `thread.start()`, it executed the `run()` method concurrently with the main thread. 

Feel free to experiment with more complex scenarios, synchronized blocks, or thread pools to dive deeper into Java threading. But always remember to handle thread synchronization and resource access carefully to avoid race conditions and data inconsistencies.

## Thread States

Threads in Java have different states throughout their lifecycle. The main thread starts in the `NEW` state and moves through `RUNNABLE`, `BLOCKED`, `WAITING`, `TIMED_WAITING`, and finally, `TERMINATED` when it completes execution.

## Thread Priority

Java threads have priority levels ranging from 1 (lowest) to 10 (highest). The default priority is 5. You can set the priority using the `setPriority(int priority)` method, but keep in mind that thread priority is just a hint to the scheduler, and it doesn't guarantee execution order.

**Step-by-step Example with Thread Priority:**

**Step 1:** Create a new Java class called `PriorityThreadExample`.

**Step 2:** Implement the `Runnable` interface in the `PriorityThreadExample` class.

```java
public class PriorityThreadExample implements Runnable {
    //
    @Override
    public void run() {
        //
        System.out.println("Thread " + Thread.currentThread().getId() + " started.");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second to simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread " + Thread.currentThread().getId() + " finished.");
    }
}
```

**Step 3:** In the `main` method, create multiple threads with different priorities and start them.

```java
public class Main {
    //
    public static void main(String[] args) {
        //
        PriorityThreadExample threadExample = new PriorityThreadExample();

        Thread thread1 = new Thread(threadExample);
        Thread thread2 = new Thread(threadExample);
        Thread thread3 = new Thread(threadExample);

        thread1.setPriority(Thread.MIN_PRIORITY);   // Set lowest priority (1)
        thread2.setPriority(Thread.NORM_PRIORITY);  // Set default priority (5)
        thread3.setPriority(Thread.MAX_PRIORITY);   // Set highest priority (10)

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
```

**Explanation:**

In this examples, we created a `PriorityThreadExample` class that implements `Runnable`. The `run()` method prints some messages and sleeps for 1 second in each iteration to simulate work. In the `main` method, we created three threads and set different priorities for them. However, keep in mind that the actual behavior of thread priority might vary depending on the platform and JVM implementation.

## Thread Join

The `join()` method allows one thread to wait for the completion of another thread. It is useful when you want to ensure that certain tasks are executed in a specific order.

**Example using Thread Join:**

```java
public class JoinThreadExample implements Runnable {
    //
    @Override
    public void run() {
        //
        System.out.println("Thread " + Thread.currentThread().getId() + " started.");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second to simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread " + Thread.currentThread().getId() + " finished.");
    }
}
```

```java
public class Main {
    //
    public static void main(String[] args) {
        //
        JoinThreadExample threadExample = new JoinThreadExample();

        Thread thread1 = new Thread(threadExample);
        Thread thread2 = new Thread(threadExample);

        thread1.start();
        try {
            thread1.join(); // Wait for thread1 to finish before starting thread2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }
}
```

**Explanation:**

In this examples, we created a `JoinThreadExample` class similar to the previous examples. In the `main` method, we created two threads: `thread1` and `thread2`. We used `thread1.join()` to make sure `thread2` starts only after `thread1` finishes its execution.

These are just some basic concepts related to Java threads. There's a lot more to explore, including thread synchronization, deadlock, and thread pools. However, this should provide a good starting point for beginners to understand the fundamental concepts of threads in Java.

## Volatile Keyword:

In multithreaded environments, the `volatile` keyword is used to ensure that the variable's value is always read from and written to the main memory, rather than relying on a thread's local cache. It helps in situations where multiple threads might access the same variable, preventing visibility issues and stale data.

**Example using Volatile Keyword:**

```java
public class VolatileExample {
    private volatile boolean flag = false;

    public void setFlag() {
        flag = true;
    }

    public void doSomething() {
        while (!flag) {
            // Perform some task here
        }
        System.out.println("Flag is set to true.");
    }
}
```

**Explanation:**

In this examples, we have a `VolatileExample` class with a `flag` variable marked as `volatile`. The `setFlag()` method updates the flag value to `true`, and the `doSomething()` method continuously checks the value of `flag` until it becomes `true`. Without the `volatile` keyword, the `doSomething()` method might not see the updated value of `flag`, leading to an infinite loop.




## Thread Synchronization

When multiple threads access shared resources simultaneously, it can lead to data inconsistency or unexpected behavior. Thread synchronization is used to ensure that only one thread can access a critical section of code at a time, preventing race conditions.

**Example of Thread Synchronization:**

```java
public class Counter {
    //
    private int count = 0;

    public synchronized void increment() {
        //
        count++;
    }

    public int getCount() {
        //
        return count;
    }
}
```

```java
public class SynchronizedThreadExample implements Runnable {
    //
    private Counter counter;

    public SynchronizedThreadExample(Counter counter) {
        //
        this.counter = counter;
    }

    @Override
    public void run() {
        //
        for (int i = 1; i <= 5; i++) {
            counter.increment();
            System.out.println("Thread " + Thread.currentThread().getId() + ": Count = " + counter.getCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java
public class Main {
    //
    public static void main(String[] args) {
        //
        Counter counter = new Counter();
        SynchronizedThreadExample threadExample = new SynchronizedThreadExample(counter);

        Thread thread1 = new Thread(threadExample);
        Thread thread2 = new Thread(threadExample);

        thread1.start();
        thread2.start();
    }
}
```

**Explanation:**

In this examples, we have a `Counter` class that contains a synchronized method `increment()`. When multiple threads access this method, they will be granted access one by one, preventing any data inconsistency in the `count` variable.

## Daemon Threads

Daemon threads are threads that run in the background and provide support to non-daemon threads. When the last non-daemon thread in an application terminates, all daemon threads are automatically terminated, regardless of their state of execution.

**Example of Daemon Threads:**

```java
public class DaemonThreadExample {
    //
    public static void main(String[] args) {
        //
        Thread daemonThread = new Thread(() -> {
            //
            while (true) {
                System.out.println("DaemonThread: I'm running in the background.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main Thread: I'm the main thread.");
    }
}
```

**Explanation:**


In this examples, we create a `daemonThread` that runs an infinite loop printing messages in the background. We set it as a daemon thread using the `setDaemon(true)` method. The main thread will continue its execution and terminate when it's done. As soon as the main thread terminates, the JVM will automatically terminate the daemon thread, regardless of its state.

Daemon threads are useful for tasks that support the application but are not crucial for its operation. Common examples include background garbage collection and loggers.

## Thread Local

`ThreadLocal` is a class that provides thread-local variables. Each thread accessing a `ThreadLocal` variable has its own, independently initialized copy of the variable. It's useful when you want to store thread-specific data.

**Example of Thread Local:**

```java
public class ThreadLocalExample {
    //
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //
        Runnable task = () -> {
            //
            int threadId = (int) Thread.currentThread().getId();
            threadLocal.set(threadId);
            System.out.println("Thread " + threadId + ": ThreadLocal value = " + threadLocal.get());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
```

**Explanation:**

In this examples, we use `ThreadLocal<Integer>` to store thread-specific data (thread ID). Each thread calls `threadLocal.set()` to set its own thread ID, and later, `threadLocal.get()` retrieves the value of the thread-local variable.

These concepts demonstrate how Java threads can be managed, interrupted, and their performance optimized using thread pools. While concurrent programming can be challenging, understanding these concepts will enable you to write efficient and reliable multithreaded applications. Remember to handle synchronization and resources with care to avoid common pitfalls like race conditions and deadlocks.

## Deadlock

Deadlock occurs when two or more threads are each waiting for the other to release a resource, resulting in a standstill where none of the threads can proceed. It is essential to avoid deadlocks in your applications.

**Example of Deadlock:**

```java
public class DeadlockExample {
    //
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        //
        Thread thread1 = new Thread(() -> {
            //
            synchronized (resource1) {
                System.out.println("Thread 1: Holding resource 1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for resource 2...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Holding resource 1 and resource 2...");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            //
            synchronized (resource2) {
                System.out.println("Thread 2: Holding resource 2...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for resource 1...");
                synchronized (resource1) {
                    System.out.println("Thread 2: Holding resource 1 and resource 2...");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
```

**Explanation:**

In this examples, we have two threads, `thread1` and `thread2`, both trying to acquire two resources, `resource1` and `resource2`, but in a different order. This can lead to a deadlock situation where thread1 holds resource1 and waits for `resource2`, while `thread2` holds `resource2` and waits for `resource1`.

**To avoid deadlocks**, you need to carefully manage the acquisition of resources and ensure that threads acquire them in a consistent and predefined order.

