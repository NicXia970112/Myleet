public class Solution {
    public static void main(String[] args) {
        for(int i = 2; i < 20; i++) {
            if(Method.checkByOne(i)) {
                System.out.print(i + "       ");
            }
        }
        System.out.println();
        for(int i = 2; i < 20; i++) {
            if(Method.checkByTwo(i)) {
                System.out.print(i + "       ");
            }
        }
    }
}

class Method {

    public static boolean checkByOne(int num) {
        for(int i = 2; i < num / 2 + 1; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkByTwo(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
