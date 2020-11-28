package low;

import java.util.Arrays;

public class 旋转数组 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public static int[] solution(int[] nums, int k) {
        System.out.println("before:" + Arrays.toString(nums));
        int length = nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[length + i - k];
        }
        for (int i = length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
        System.out.println("==" + Arrays.toString(nums));

        System.out.println("after:" + Arrays.toString(nums));
        return nums;
    }

}
