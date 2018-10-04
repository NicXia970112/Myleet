public class selectSort {
    public static void main(String []args) {
        int []nums = {1,3,2,7,6};
        selectSort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void selectSort(int []nums) {
        int min,i,j;
        for(i = 0; i < nums.length; i++) {
            min = i;
            for(j = i + 1; j < nums.length;j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int k;
                k = nums[i];
                nums[i] = nums[min];
                nums[min] = k;
            }
        }
    }
}

