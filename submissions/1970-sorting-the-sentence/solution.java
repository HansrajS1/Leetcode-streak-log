class Solution {
    public String sortSentence(String s) {
        String[] parts = s.split(" ");
        String[] result = new String[parts.length];
        
        for (String word : parts) {
            int idx = word.charAt(word.length() - 1) - '0';
            result[idx - 1] = word.substring(0, word.length() - 1);
        }
        
        return String.join(" ", result);
    }
}
