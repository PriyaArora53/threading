package com.threading;

public class CourseNotifier {

    public static void main(String[] args) throws InterruptedException {
        Course course = new Course("Java Multithreaded Programming");

        //two threads for student notification and one for the instructor

        new Thread(()->{
            synchronized (course){
                System.out.println(Thread.currentThread().getName() + " is waiting for the course to get started");
                try{
                    course.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " the course: " + course.getTitle()
                + " is now completed");
            }

        },"Student A").start();

        new Thread(()->{
            synchronized (course){
                System.out.println(Thread.currentThread().getName() + " is waiting for the course to get started");
                try{
                    course.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " the course: " + course.getTitle()
                + " is now completed");
            }
        },"Student B").start();

        Thread.sleep(2000);
        new Thread(()->{
            synchronized (course){
                System.out.println(Thread.currentThread().getName() + " is starting a new course "
                        + course.getTitle());
                try {
                    Thread.sleep(4000);
                    course.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Priya").start();

    }

}

class Course{

    private String title;
    private boolean completed;

    public Course(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
