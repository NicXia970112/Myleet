import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String in = scn.nextLine();
        String []nums = in.split("[,]");
        int []Nums = new int[nums.length];
        int k = 0;
        for(String number: nums) {
            Nums[k] = Integer.parseInt(number);
            k++;
        }
        int i,j;
        for(i = 0; i < 3; i++) {
            for(j = i + 1; j < Nums.length;j++) {
                if(Nums[i] > Nums[j]) {
                    int m = Nums[i];
                    Nums[i] = Nums[j];
                    Nums[j] = m;
                }
            }
        }
    }

}
