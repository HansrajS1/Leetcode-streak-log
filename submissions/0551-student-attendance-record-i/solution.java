class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateStreak = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                absentCount++;
                if (absentCount > 1) return false;
                lateStreak = 0; 
            } else if (ch == 'L') {
                lateStreak++;
                if (lateStreak >= 3) return false;
            } else {
                lateStreak = 0;
            }
        }

        return true;
    }
}
