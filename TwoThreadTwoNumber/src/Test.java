public class Test {


    public static void main(String []args) {
        Num num = new Num();
        JiPrinter j = new JiPrinter();
        OuPrinter o = new OuPrinter();
        j.setNum(num);
        o.setNum(num);
        new Thread(j).start();
        new Thread(o).start();
    }

}

class Num {

    public boolean flag = false; //false打印奇数，true打印偶数

}

class JiPrinter implements Runnable{

    private  Num num;

    public Num getNum() {
        return num;
    }

    public void setNum(Num num) {
        this.num = num;
    }


    @Override
    public void run() {
        int i = 1;
        while (i < 20) {
            synchronized (num) {
                if(num.flag == false) {
                    System.out.println(i);
                    i += 2;
                    num.flag = true;
                    num.notify();
                } else {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class OuPrinter implements Runnable{

    private  Num num;

    public Num getNum() {
        return num;
    }

    public void setNum(Num num) {
        this.num = num;
    }


    @Override
    public void run() {
        int i = 2;
        while (i < 20) {
            synchronized (num) {
                if(num.flag == true) {
                    System.out.println(i);
                    i += 2;
                    num.flag = false;
                    num.notify();
                } else {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}