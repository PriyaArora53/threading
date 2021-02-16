package com.threading;

/* A factory supervisor is assigning task to workers in parallel.
He assigns the task to both worker1 and worker2 simultaneously. */
public class SupervisorExampleWithThread {
    public static void main(String[] args) {
        ParallelWorker1 parallelWorker1 = new ParallelWorker1();
        ParallelWorker2 parallelWorker2 = new ParallelWorker2();

        parallelWorker1.start();
        parallelWorker2.start();
    }
}

class ParallelWorker1 extends Thread {
   @Override
    public void run(){
       for(int i=0; i<10; i++){
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(" The worker1 is executing the task: " + i);
       }
   }
}

class ParallelWorker2 extends Thread {
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" The worker2 is executing the task: " + i);
        }

    }
}