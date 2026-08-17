class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        
    
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        

        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
        
            if (seen[c - 'a']) {
                continue;
            }
            
        
            while (stack.length() > 0 && 
                   c < stack.charAt(stack.length() - 1) && 
                   lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {
                
                
                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                seen[removed - 'a'] = false;
            }
            
    
            stack.append(c);
            seen[c - 'a'] = true;
        }
        
        return stack.toString();
    }
}
