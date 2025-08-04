class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            set.add(i);
        }
        System.out.print(set.size());
        System.out.print(nums.length);
        return set.size() != nums.length ;
    }
}
