class Solution {
    public int subsequencePairCount(int[] nums) {
        int MOD = 1000000007;
        int maxVal = 0;
        for (int x : nums) {
            if (x > maxVal) maxVal = x;
        }
        int[][] dp = new int[maxVal + 1][maxVal + 1];
        dp[0][0] = 1; 
        
        for (int x : nums) {
            int[][] nextDp = new int[maxVal + 1][maxVal + 1];
            
            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    if (dp[g1][g2] == 0) continue;
                    
                    long ways = dp[g1][g2];
                    
                    nextDp[g1][g2] = (int) ((nextDp[g1][g2] + ways) % MOD);
                    
                    int nextG1 = (g1 == 0) ? x : gcd(g1, x);
                    nextDp[nextG1][g2] = (int) ((nextDp[nextG1][g2] + ways) % MOD);
                    
                    int nextG2 = (g2 == 0) ? x : gcd(g2, x);
                    nextDp[g1][nextG2] = (int) ((nextDp[g1][nextG2] + ways) % MOD);
                }
            }
            dp = nextDp;
        }
        long ans = 0;
        for (int g = 1; g <= maxVal; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        
        return (int) ans;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
