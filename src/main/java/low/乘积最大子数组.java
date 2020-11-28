package low;

public class 乘积最大子数组 {


    public static void main(String[] args) {
        int[] input = new int[]{2, 3, -2, 14, 1, 7};
        int res = solution(input);
        System.out.printf("res=" + res);
    }

    /**
     * dp[i] = 以第i个元素结尾的最大乘积值max()
     * max_dp[i] = max(i,max_dp[i-1]*i,min_dp[i-1]*i)
     * min_dp[i] = min(i,max_dp[i-1]*i,min_dp[i-1]*i)
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        //System.arraycopy(nums, 0, maxF, 0, length);
        //System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            System.out.println("i=" + i + "#" + maxF[i] + "$$" + minF[i]);
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

}
