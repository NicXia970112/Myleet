public class Compare {

    public static void main(String args[]) {
        Compare c = new Compare();
        System.out.println(c.compare(3, 2));
    }

    public boolean compare(int x, int y) { // x的y次方大，返回true
        int xy = x;
        for(int i = 0; i < y - 1; i++) {
            xy = xy * x; //x的y次方
        }
        double t =  Math.pow(xy, (double) 1 / x);
        if(t < y) {
            return false;
        } else return true;
    }

}
