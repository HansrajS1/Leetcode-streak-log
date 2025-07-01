class Solution {public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for (char digit : digits.toCharArray()) {
            String letters = digitToLetters.get(digit);
            int size = queue.size();

            while (size-- > 0) {
                String current = queue.poll();

                for (char letter : letters.toCharArray()) {
                    queue.offer(current + letter);
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
