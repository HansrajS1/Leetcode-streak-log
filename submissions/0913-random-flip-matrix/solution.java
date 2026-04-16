
class Solution {

    private int rows, cols, total;
    private HashMap<Integer, Integer> map;
    private Random rand;

    public Solution(int m, int n) {
        rows = m;
        cols = n;
        total = m * n;
        map = new HashMap<>();
        rand = new Random();
    }

    public int[] flip() {
        int r = rand.nextInt(total);
        total--;

        int x = map.getOrDefault(r, r);

        map.put(r, map.getOrDefault(total, total));

        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }
}
