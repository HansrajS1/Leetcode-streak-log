class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int samePoint = 1;
            int currMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    samePoint++;
                } else {
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }

                    String key = dy + "/" + dx;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    currMax = Math.max(currMax, map.get(key));
                }
            }
            result = Math.max(result, currMax + samePoint);
        }
        return result;
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

