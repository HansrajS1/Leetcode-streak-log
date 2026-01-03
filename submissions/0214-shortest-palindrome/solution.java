class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;

        int[] lps = buildLPS(temp);

        int longestPrefix = lps[temp.length() - 1];
        String suffix = s.substring(longestPrefix);

        return new StringBuilder(suffix).reverse().toString() + s;
    }

    private int[] buildLPS(String s) {
        int[] lps = new int[s.length()];
        int len = 0;

        for (int i = 1; i < s.length(); i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        return lps;
    }
}

