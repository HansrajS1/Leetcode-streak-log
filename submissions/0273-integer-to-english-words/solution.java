class Solution {

    private final String[] belowTen = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine"
    };

    private final String[] belowTwenty = {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] belowHundred = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder res = new StringBuilder();

        if (num >= 1_000_000_000) {
            res.append(helper(num / 1_000_000_000)).append(" Billion");
            num %= 1_000_000_000;
        }

        if (num >= 1_000_000) {
            if (res.length() > 0) res.append(" ");
            res.append(helper(num / 1_000_000)).append(" Million");
            num %= 1_000_000;
        }

        if (num >= 1000) {
            if (res.length() > 0) res.append(" ");
            res.append(helper(num / 1000)).append(" Thousand");
            num %= 1000;
        }

        if (num > 0) {
            if (res.length() > 0) res.append(" ");
            res.append(helper(num));
        }

        return res.toString();
    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(belowTen[num / 100]).append(" Hundred");
            num %= 100;
        }

        if (num >= 20) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(belowHundred[num / 10]);
            num %= 10;
        }

        if (num >= 10) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(belowTwenty[num - 10]);
            return sb.toString();
        }

        if (num > 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(belowTen[num]);
        }

        return sb.toString();
    }
}

