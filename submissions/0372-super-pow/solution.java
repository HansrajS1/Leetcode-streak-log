class Solution {
    public int superPow(int a, int[] b) {
        a = a % 1337;
        int result = 1;

        for (int i = 0; i < b.length; i++) {
            result = (int) ((long) power(result, 10) * power(a, b[i]) % 1337);
        }

        return result;
    }

    public int power(int a, int b) {
        int result = 1;

        while (b > 0) {
            result = (int) ((long) result * a % 1337);
            b--;
        }

        return result;
    }
}
