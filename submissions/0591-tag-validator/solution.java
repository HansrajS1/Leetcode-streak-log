class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = code.length();

        while (i < n) {
            if (code.charAt(i) != '<') {
                if (stack.isEmpty()) return false;
                i++;
                continue;
            }
            if (i + 9 < n && code.startsWith("<![CDATA[", i)) {
                if (stack.isEmpty()) return false;
                int end = code.indexOf("]]>", i);
                if (end == -1) return false;
                i = end + 3;
            }
            else if (i + 2 < n && code.charAt(i + 1) == '/') {
                int end = code.indexOf('>', i);
                if (end == -1) return false;

                String tag = code.substring(i + 2, end);
                if (!isValidTagName(tag)) return false;

                if (stack.isEmpty() || !stack.pop().equals(tag))
                    return false;

                i = end + 1;

                if (stack.isEmpty() && i < n)
                    return false;
            }
            else {
                int end = code.indexOf('>', i);
                if (end == -1) return false;

                String tag = code.substring(i + 1, end);
                if (!isValidTagName(tag)) return false;

                stack.push(tag);
                i = end + 1;
            }
        }

        return stack.isEmpty();
    }

    private boolean isValidTagName(String tag) {
        if (tag.length() < 1 || tag.length() > 9) return false;
        for (char c : tag.toCharArray()) {
            if (c < 'A' || c > 'Z') return false;
        }
        return true;
    }
}
