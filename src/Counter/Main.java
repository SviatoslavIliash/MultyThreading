package Counter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Святослав on 10.01.2015.
 */
public class Main {
    public static class Child extends Thread {
        Boolean stop = false;
        public void run(){
            ArrayList<Child> threads = new ArrayList<Child>();
            for (int i = 0; i < 5; i++) {
                Child child = new Child();
                child.start();
                threads.add(child);
            }
            for (Child child : threads)
                System.out.println("Child thread: "+child.getId());
            for(Child child: threads){
                child.interrupt();
            }

        }
        public  void stoP(ArrayList<Child> threads){

        }
    }
    public static class Counter extends Thread {
        int in;
        int out;
        Child child;
        public Counter(int in, int out){
            this.in = in;
            this.out = out;
        }
        public void run() {
            child = new Child();
            child.start();
            child.interrupt();
            /*for (Counter c : threads)
                c.interrupt();*/

            //while (!interrupted()) {
                //int x = in;
                //while (x <= out) {
                    //System.out.print(x++ + " ");

              //  }


                //System.out.println();
            }

    }
    //}
    public static void main(String[] args) throws Exception{
        /*InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String in = bufferedReader.readLine();
        String out = bufferedReader.readLine();
        int inInt = Integer.parseInt(in);
        int outInt = Integer.parseInt(out);
        try {
            Counter c = new Counter(inInt, outInt);
            c.start(); // запускаем поток
            Thread.sleep(1000);
            c.interrupt(); // ждем завершения потока
            System.out.println("Thread finished");
        } catch (Exception e) {
            ;
        }*/
        Counter c = new Counter(1,2);
        c.start();
        c.interrupt();

    }
}