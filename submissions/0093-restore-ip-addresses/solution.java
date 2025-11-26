class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int index, List<String> path) {
        if (path.size() == 4 && index == s.length()) {
            result.add(String.join(".", path));
            return;
        }
        if (path.size() == 4) return;

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;
            String segment = s.substring(index, index + len);
            if (segment.length() > 1 && segment.charAt(0) == '0') break;
            if (Integer.parseInt(segment) > 255) break;
            path.add(segment);
            backtrack(s, index + len, path);
            path.remove(path.size() - 1);
        }
    }
}

