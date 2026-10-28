class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1])
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{nums1[i], nums2[0], i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();

            result.add(Arrays.asList(pair[0], pair[1]));

            int i = pair[2];
            int j = pair[3];

            if (j + 1 < nums2.length) {
                pq.offer(new int[]{nums1[i], nums2[j + 1], i, j + 1});
            }

            k--;
        }

        return result;
    }
}

