class Solution {
    public int minTimeToType(String word) {
         int time = 0;
        char prev = 'a';
        
        for (char c : word.toCharArray()) {
            int diff = Math.abs(c - prev);
            int move = Math.min(diff, 26 - diff);
            time += move + 1;
            prev = c;
        }
        
        return time;
    }
}
