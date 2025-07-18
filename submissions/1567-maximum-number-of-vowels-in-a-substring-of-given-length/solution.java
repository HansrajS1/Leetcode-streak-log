class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, currentVowels = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
            
            if (i >= k && vowels.contains(s.charAt(i - k))) {
                currentVowels--;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}
