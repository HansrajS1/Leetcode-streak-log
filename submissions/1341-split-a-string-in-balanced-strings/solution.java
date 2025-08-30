class Solution {
    public int balancedStringSplit(String s) {
        int bal = 0, count = 0;  
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                bal++;
            } else {
                bal--;
            }
            
            if (bal == 0) {
                count++;
            }
        }
        
        return count;
    }
}
