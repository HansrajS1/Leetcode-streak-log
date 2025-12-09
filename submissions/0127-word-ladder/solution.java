class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Map<String, List<String>> patternMap = new HashMap<>();
        int L = beginWord.length();
        for (String word : wordSet) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (int j = 0; j < L; j++) {
                    String pattern = curr.substring(0, j) + "*" + curr.substring(j + 1);
                    List<String> neighbors = patternMap.getOrDefault(pattern, new ArrayList<>());

                    for (String next : neighbors) {
                        if (next.equals(endWord)) return steps + 1;

                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
