class Solution {
    public int findComplement(int num) {
        int num1 = (1 << Integer.toBinaryString(num).length()) - 1;
        return num ^ num1;
    }
}
