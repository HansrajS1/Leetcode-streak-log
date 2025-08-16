class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for (int n : nums2) {
            if (map.getOrDefault(n, 0) > 0) {
                result.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
