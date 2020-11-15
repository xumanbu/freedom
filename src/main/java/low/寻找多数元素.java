package low;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 寻找多数元素 {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement1(nums);
        System.out.println(result);
        System.out.println(majorityElement(nums));
    }


    // Hash计数法
    public static int majorityElement1(int[] nums) {
        Map<Integer,Integer> numCount = new TreeMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(numCount.containsKey(nums[i])){
                numCount.put(nums[i],numCount.get(nums[i])+1);
            }else {
                numCount.put(nums[i],1);
            }
        }

        System.out.println(numCount);
        double n = Math.ceil(nums.length/2.0);
        System.out.println(n);
        for (Integer key:numCount.keySet()){
            if(numCount.get(key)>=n){
                return key;
            }
        }
        return -1;
    }

    //Boyer-Moore
    //我们维护一个计数器，如果遇到一个我们目前的候选众数，就将计数器加一，否则减一。
    // 只要计数器等于 0 ，我们就将 nums 中之前访问的数字全部 忘记 ，并把下一个数字当做候选的众数。
    public static int majorityElement(int[] nums){
        int candidate = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0)candidate=nums[i];
            count+=(candidate == nums[i])?1:-1;
        }
        return candidate;
    }


}
