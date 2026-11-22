class Solution {
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");

        int[] lengths = new int[arr.length + 1];
        int max = 0;

        for (String s : arr) {
            int level = s.lastIndexOf("\t") + 1;

            String name = s.substring(level);

            int length = name.length();

            if (name.contains(".")) {
                max = Math.max(max, lengths[level] + length);
            } else {
                lengths[level + 1] = lengths[level] + length + 1;
            }
        }

        return max;
    }
}

