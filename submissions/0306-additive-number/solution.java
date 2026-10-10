class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;

            for (int j = i + 1; j < n; j++) {
                int len2 = j - i;
                int len3 = n - j;

                if (Math.max(i, len2) > len3) continue;

                if (num.charAt(i) == '0' && len2 > 1) break;

                if (check(num, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(String num, int i, int j) {
        String a = num.substring(0, i);
        String b = num.substring(i, j);

        while (j < num.length()) {
            String sum = addStrings(a, b);

            if (!num.startsWith(sum, j)) {
                return false;
            }

            j += sum.length();
            a = b;
            b = sum;
        }

        return true;
    }

    private String addStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}
