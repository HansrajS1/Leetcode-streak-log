class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new TreeSet<>();
        for (int i : nums) {
            s.add(i);
        }
        int i = 0;
        for (int num : s) {
            nums[i++] = num;
        }
        return s.size();
    }
}
