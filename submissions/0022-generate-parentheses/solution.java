class Solution {
    public void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
    public List<String> generateParenthesis(int n) {
        int open = 0 , close = 0;
        String current = "";
        List<String> result = new ArrayList<>();
        backtrack(result,current,open,close,n);
        return result;
    }
}
