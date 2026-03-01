class Solution {
    public int evalRPN(String[] tokens) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/")) {
                
                int b = stack.pop();
                int a = stack.pop();
                
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } 
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
