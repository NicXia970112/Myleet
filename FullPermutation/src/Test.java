import javax.swing.plaf.FontUIResource;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Test{
    public static void main(String[] args) {
        FullPermutation f = new FullPermutation();
        f.nums = new int[]{1, 3, 4, 5, 6};
        f.visit = new int[f.nums.length];
        f.result = new int[f.nums.length];

        f.Permutation(0,5);
        System.out.println(f.count);
    }
}

class FullPermutation {
    int count = 0;
    int nums[];
    int visit[];
    int result[];

    public void Permutation(int n,int end) {
        if(n == end) {
            log(result);
            count++;
            System.out.println();
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visit[i] == 0) {
                visit[i] = 1;
                result[n] = nums[i];
                Permutation(n + 1, end);


                visit[i] = 0;
            }
        }
    }

    public void log(int nums[]) {
        for(int k: nums) {
            System.out.print(k);
        }
        System.out.println();
    }
}