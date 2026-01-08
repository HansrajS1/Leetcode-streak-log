class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;

        int[] lps = new int[temp.length()];
        int j = 0;

        for (int i = 1; i < temp.length(); i++) {
            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
                j = lps[j - 1];
            }
            if (temp.charAt(i) == temp.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        int palPrefixLen = lps[temp.length() - 1];
        String remaining = s.substring(palPrefixLen);

        return new StringBuilder(remaining).reverse().toString() + s;
    }
}

