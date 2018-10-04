import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String in = input.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("[,]", "");
        int[] Nums = new int[in.toCharArray().length];
        int i = 0;
        for(char c: in.toCharArray()) {
            Nums[i] = c - '0';
            i++;
        }
//        System.out.println(Util.rHeight(Nums,8));
        System.out.println(Util.sum(Nums));
    }

}

class Util {

    private static int count = 0;

    public static int sum(int nums[]) {
        int i = 0;
        while( i != nums.length - 1) {
            int r = rHeight(nums, i);
            int h = nums[i] < nums[r] ? nums[i] : nums[r];
            for(int m = i; m < r; m++) {
                int water = h - nums[m];
                count += water;
            }
            i = r + 1;
        }
        return count;
    }

    public static int rHeight(int nums[], int n) {
        for(int i = n + 1; i < nums.length; i++) {
            if(nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return n;
    }

}