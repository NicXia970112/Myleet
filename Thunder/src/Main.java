import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a,b,c;
        int count = 0;
        for(a = 1; a < n; a++) {
            for(b = a + 1; b < n; b++) {
                for (c = b + 1; c < n; c++) {
                    if(Util.check(a,b,c)) {
                      if(a*a + b*b == c*c) {
                          count++;
                      }
                    }
                }
            }
        }
        System.out.println(count);
    }
}

class Util {

    public static boolean check(int a, int b, int c) {
        if(a > b) {
            if(a % b == 0) {
                return false;
            }
        } else {
            if( b % a == 0) {
                return false;
            }
        }

        if(a > c) {
            if(a % c == 0) {
                return false;
            }
        } else {
            if( c % a == 0) {
                return false;
            }
        }

        if(c > b) {
            if(c % b == 0) {
                return false;
            }
        } else {
            if( b % c == 0) {
                return false;
            }
        }
        return true;
    }

}

