class Solution {
    public boolean validUtf8(int[] data) {
        int remainingBytes = 0;

        for (int num : data) {

            if (remainingBytes == 0) {
                int mask = 1 << 7;
                int count = 0;
                
                while ((num & mask) != 0) {
                    count++;
                    mask >>= 1;
                }

                if (count == 1 || count > 4) return false;

                if (count > 0) {
                    remainingBytes = count - 1;
                }
            } else {
                if ((num >> 6) != 2) return false;
                remainingBytes--;
            }
        }

        return remainingBytes == 0;
    }
}
