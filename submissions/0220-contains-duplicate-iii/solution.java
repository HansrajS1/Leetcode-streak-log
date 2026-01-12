class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    if (indexDiff <= 0 || valueDiff < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long x = nums[i];
            Long candidate = set.ceiling(x - valueDiff);
            if (candidate != null && candidate <= x + valueDiff) {
                return true;
            }
            set.add(x);
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
