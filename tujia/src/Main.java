import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String in = scn.nextLine();
        int input = Integer.parseInt(in);
        int result = 0;
        for(int i = 0; i < input; i++) {
            if(Method.getSum(i) < input && Method.getSum(i + 1) > input ) {
                result = i + 1;
            }
        }
        System.out.println(result);
    }
}

class Method {
    public static int getSum(int k) {
        int sum = 0;
        for(int i = 1; i <= k; i++) {
            sum += i;
        }
        return sum;
    }
}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int count = Integer.parseInt(scn.nextLine());
//        int []result = new int[count];
//        for(int i = 0; i < count; i++) {
//            String s = scn.nextLine();
//            String []S = s.split(" ");
//            int []input = new  int[S.length];
//            int m = 0;
//            for(String v : S) {
//                input[m] = Integer.parseInt(v);
//                m++;
//            }
//            Method.getCount(result, i, input);
//        }
//        for(int i: result) {
//            System.out.println(i);
//        }
//
//    }
//}
//
//class Method {
//
//    public static void getCount(int []count, int p, int in[]) {
//        int i,j;
//        for(i = 0; i < in.length - 1; i++) {
//            for(j = i + 1; j < in.length; j++) {
//                if(!isInArray(in, Math.abs(in[i] - in[j]))) {
//                    count[p] ++;
//                }
//            }
//        }
//    }
//
//    public static boolean isInArray(int []in, int k) {
//        for(int v: in) {
//            if(k == v) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}