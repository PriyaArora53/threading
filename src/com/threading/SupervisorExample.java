package com.threading;

/* A factory supervisor is assigning task to workers in sequential order.
He assigns the task to worker1. When worker 1 is done then worker2 is assigned a task*/
public class SupervisorExample {

    public static void main(String[] args) throws InterruptedException {
        Worker1 worker1 = new Worker1();
        Worker2 worker2 = new Worker2();

        worker1.executeWork();
        worker2.executeWork();
    }
}

//internal class
class Worker1 {
    public void executeWork() throws InterruptedException {
        for (int i=0; i<10; i++){
            Thread.sleep(100);
            System.out.println(" Worker 1 is executing the task: " + i);
        }
    }
}

class Worker2 {
    public void executeWork() throws InterruptedException {
        for (int i=0; i<10; i++){
            Thread.sleep(100);
            System.out.println(" Worker 2 is executing the task: " + i);
        }
    }
}
