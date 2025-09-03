class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int total = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - i;
            int totalSubarrays = start * end;
            int oddCount = (totalSubarrays + 1) / 2;
            total += arr[i] * oddCount;
        }

        return total;
    }
}
