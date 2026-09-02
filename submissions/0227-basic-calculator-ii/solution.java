class Solution {
    public int calculate(String s) {
        int n = s.length();
        int result = 0;
        int last = 0;
        int num = 0;
        char op = '+';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (op == '+') {
                    result += last;
                    last = num;
                } else if (op == '-') {
                    result += last;
                    last = -num;
                } else if (op == '*') {
                    last = last * num;
                } else if (op == '/') {
                    last = last / num;
                }

                op = c;
                num = 0;
            }
        }

        return result + last;
    }
}

