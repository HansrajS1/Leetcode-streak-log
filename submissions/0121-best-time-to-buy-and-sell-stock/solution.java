class Solution {
    public int maxProfit(int[] prices) {
        int minp = Integer.MAX_VALUE;
        int maxp = 0;

        for (int price : prices) {
            int cmax = price - minp;
            if (price < minp) {
                minp = price;
            } 
            else if ( cmax > maxp) {
                maxp = cmax;
            }
        }

        return maxp;
    }
}
