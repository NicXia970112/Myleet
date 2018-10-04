

public class QuickSort {

    public static void main(String args[]) {
        QuickSort qs = new QuickSort();
        int []nums = {1,3,2,4,1,5,8,7,8};
        qs.qs(nums,0,nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

//    public void qs(int []nums, int left, int right) {
//        if(left > right) {
//            return;
//        }
//
//        int l = left;
//        int r = right;
//        int std = nums[left];
//
//        while (l != r) {
//
//            while (l < r && nums[r] >= std) {
//                r--;
//            }
//
//            while (l < r && nums[l] <= std) {
//                l++;
//            }
//
//            if(l < r) {
//                int t;
//                t = nums[l];
//                nums[l] = nums[r];
//                nums[r] = t;
//            }
//        }
//
//        int a = nums[l];
//        nums[l] = nums[left];
//        nums[left] = a;
//
//        qs(nums, 0, l - 1);
//        qs(nums, l + 1, right);
//
//    }

    public void qs(int []nums, int left, int right) {
        if(right < left) {
            return;
        }

        int l = left;
        int r = right;
        int std = nums[left];

        while (l != r) {
            while (l < r && nums[r] >= std) {
                r--;
            }
            while (l < r && nums[l] <= std) {
                l++;
            }
            if(l < r) {
                int k = nums[r];
                nums[r] = nums[l];
                nums[l] = k;
            }
        }

        int k = nums[l];
        nums[l] = nums[left];
        nums[left] = k;

        qs(nums, 0, l - 1);
        qs(nums, l + 1, right);
    }
}