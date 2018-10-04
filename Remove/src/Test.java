public class Test {
    public static void main(String []args) {
        int []nums = {1,1,1,3,3,4,4,4,5};
        Method m = new Method();
        System.out.println(m.remove(nums));
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

class Method {
    public int count = 0;
    
    public void moveToTail(int []nums, int begin, int tail) {
        int v = nums[begin];
        for (int i = begin; i <= tail; i++) {
            if(i == tail) {
                nums[i] = v;
            }
            if(i < tail) {
                nums[i] = nums[i + 1];
            }
        }
    }
    
    public int remove(int []nums) {
        int i,j;
        for(i = 0; i < nums.length - count - 1; i++) {
            for(j = i + 1; j < nums.length - count; j++) {
                if(nums[i] == nums[j]) {
                    moveToTail(nums,j,nums.length - 1); //j移动到尾端，后面所有节点前移一位
                    count++;
                    if(nums[i] == nums[j]) {
                        j--;
                    }
                }
            }
        }
        return nums.length - count;
    }
}
