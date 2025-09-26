class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int S = 0;
        for (int num : nums) {
            S += num;
        }
        if ((S + target) % 2 != 0 || Math.abs(target) > S) {
            return 0;
        }
        int P = (S + target) / 2;
        return subsetSum(nums, P);
    }

    private int subsetSum(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; 
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }
}
