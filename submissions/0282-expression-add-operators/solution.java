class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        solve(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void solve(String num, long target, int index,
                       long value, long prev, String expr,
                       List<String> result) {

        if (index == num.length()) {
            if (value == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String part = num.substring(index, i + 1);
            long n = Long.parseLong(part);

            if (index == 0) {
                solve(num, target, i + 1, n, n, part, result);
            } else {
                solve(num, target, i + 1, value + n, n,
                      expr + "+" + part, result);

                solve(num, target, i + 1, value - n, -n,
                      expr + "-" + part, result);

                solve(num, target, i + 1,
                      value - prev + prev * n, prev * n,
                      expr + "*" + part, result);
            }
        }
    }
}
