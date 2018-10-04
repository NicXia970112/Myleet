public class InsetSort {

    public static void main(String []args) {
        int nums[] = {1,4,6,2,8,10};
        InsetSort insetSort = new InsetSort();
        insetSort.sort(nums);
        //insetSort.moveTotail(2,nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void sort(int nums[]) {
        int i,j;
        int tmp;
        for(i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                continue;
            }
            for (j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i] && nums[j + 1] > nums[i]) {
                    tmp = nums[i];
                    moveTotail(j + 1, nums, i);
                    nums[j + 1] = tmp;

                }
            }
        }
    }

    public void moveTotail(int k, int nums[], int edge) {
        for(int i = edge; i >= k + 1; i--) {
            nums[i] = nums[i - 1];
        }
    }

}
