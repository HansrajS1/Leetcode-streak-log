class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        long[] ugly = new long[n];
        int[] idx = new int[k];
        
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            long nextVal = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                nextVal = Math.min(nextVal, (long) primes[j] * ugly[idx[j]]);
            }

            ugly[i] = nextVal;

            for (int j = 0; j < k; j++) {
                if (nextVal == (long) primes[j] * ugly[idx[j]]) {
                    idx[j]++;
                }
            }
        }

        return (int) ugly[n - 1];
    }
}
