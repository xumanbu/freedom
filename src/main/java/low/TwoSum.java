package low;

import java.util.Arrays;

public class TwoSum {


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,6,7,8,10};
        System.out.println(Arrays.toString(solution(nums,12)));
    }

    public static int[] solution(int[] nums,int target){
        int l = 0,r = nums.length-1;
        while (l<r){
            int sum = nums[l]+nums[r];
            if(sum==target){
                return new int[]{nums[l],nums[r]};
            }else if(sum>target){
                r--;
            }else if(sum<target){
                l++;
            }
        }
        return null;
    }

}
