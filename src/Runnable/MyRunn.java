package Runnable;

/**
 * Created by Святослав on 10.01.2015.
 */
public class MyRunn {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() { // анонимный класс
            public void run() {
                int x = 0;
                while (x < 10)
                    System.out.println(x++);
            }
        });
        t.start();
    }
}

