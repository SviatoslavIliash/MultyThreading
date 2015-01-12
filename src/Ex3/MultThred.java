package Ex3;

import java.util.ArrayList;

/**
 * Created by Святослав on 12.01.2015.
 */
public class MultThred extends Thread {
    Child child;
    public static class Child extends Thread{
        @Override
        public void run(){
            Child child = new Child();
            System.out.println("Child thread: " + child.getId());
            try {
                child.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void run(){
        ArrayList<Child> threads = new ArrayList<Child>();
        for (int i = 0; i < 10; i++) {
            Child child = new Child();
            child.start();
            threads.add(child);

        }
        for(Child child: threads) {
            try {
                child.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(Child child: threads){
            child.interrupt();
        }
    }

    public static void main(String[] args) {
        ArrayList<Child> threads = new ArrayList<Child>();
        for (int i = 0; i < 10; i++) {
            Child child = new Child();
            child.start();
            threads.add(child);

        }
        /*for(Child child: threads) {
            try {
                child.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(Child child: threads){
            child.interrupt();
        }
    }
}
