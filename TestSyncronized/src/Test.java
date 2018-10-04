import java.awt.*;

public class Test {
    public static void main(String[] args) {
//        final Object a = new Object();
//        final Object b = new Object();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (a) {
//                    try {
//                        Thread.sleep(3000);
//                        synchronized (b) {
//                            System.out.print("hELLO a");
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (b) {
//                    try {
//                        Thread.sleep(3000);
//                        synchronized (a) {
//                            System.out.println("Hello B");
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
        Test  t = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.test1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.test2();
            }
        }).start();

    }


    public synchronized void test1() {
        System.out.println("1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test2() {
        System.out.println("2");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
