class Solution {
    private int count = 0;  

    public int totalNQueens(int n) {
        count = 0;  
        backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return count;
    }

    private void backtrack(int row, int n, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int pd = row + col;
            int nd = row - col;

            if (cols.contains(col) || posDiag.contains(pd) || negDiag.contains(nd))
                continue;

            cols.add(col);
            posDiag.add(pd);
            negDiag.add(nd);

            backtrack(row + 1, n, cols, posDiag, negDiag);

            cols.remove(col);
            posDiag.remove(pd);
            negDiag.remove(nd);
        }
    }
}
