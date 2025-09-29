class Solution {
    public int calculate(String s) {
        int result = 0;  
        int sign = 1;   
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                result += sign * num;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result *= stack.pop();
                result += stack.pop();
            }
        }
        return result;
    }
}
