class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int gcdLength = 1;
        for (int i = 1; i <= Math.min(len1, len2); i++) {
            if (len1 % i == 0 && len2 % i == 0) {
                gcdLength = i;
            }
        }
        return str1.substring(0, gcdLength);
    }
}
