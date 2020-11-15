package low;

public class 只出现一次的数字 {

    public static void main(String[] args) {
        int[] nums = {};
        System.out.printf(""+singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
