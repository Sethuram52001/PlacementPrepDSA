package problems;

import java.util.Arrays;

public class SortColors {
    private static void sortColors(int[] nums) {
        int l = 0, h = nums.length - 1, mid = 0;
        
        while(mid <= h) {
            if(nums[mid] == 0) {
                swap(nums, l, mid);
                l++;
                mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, h);
                h--;
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
