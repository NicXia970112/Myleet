import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String in = scn.nextLine();
        String []n = in.split("[,]");
        int []nums = new int[n.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(n[i].replaceAll("[^0-9]",""));
        }
        System.out.println(Method.firstMissingPositive(nums));
    }

}

class Method {

    public static int firstMissingPositive(int nums[]) {
        for(int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private static void swap(int []nums, int a, int b) {
        int k = nums[a];
        nums[a] = nums[b];
        nums[b] = k;
    }

}
