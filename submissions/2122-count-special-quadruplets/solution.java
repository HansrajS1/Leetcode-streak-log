class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for (int d = 3; d < n; d++) {
            for (int a = 0; a < d; a++) {
                for (int b = a + 1; b < d; b++) {
                    for (int c = b + 1; c < d; c++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
