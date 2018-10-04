import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("t1 begin...");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t1.interrupt();

//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("t2 begin...");
//                for(int i = 0; i < 1000000; i++) {
//                    if(i == 999999) {
//                        System.out.println("end");
//                    }
//                }
//            }
//        });
//        t2.start();
//        //t2.interrupt();
//        System.out.println(t2.isInterrupted());

        Lock lock = new ReentrantLock();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        t3.interrupt();

    }
}
