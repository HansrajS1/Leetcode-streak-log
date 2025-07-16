class Solution {
    public int maximumLength(int[] nums) {
        int altLength = 1;
        int prevParity = nums[0] % 2;

        for (int i = 1; i < nums.length; i++) {
            int currParity = nums[i] % 2;
            if (currParity != prevParity) {
                altLength++;
                prevParity = currParity;
            }
        }
        int evenCount = 0, oddCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }

        int sameParityLength = Math.max(evenCount, oddCount);
        return Math.max(altLength, sameParityLength);
    }
}
