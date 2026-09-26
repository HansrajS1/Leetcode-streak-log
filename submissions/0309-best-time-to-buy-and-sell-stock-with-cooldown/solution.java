class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int sold = 0;
        int cooldown = 0;

        for (int i = 1; i < prices.length; i++) {
            int oldHold = hold;
            int oldSold = sold;
            int oldCooldown = cooldown;

            hold = Math.max(oldHold, oldCooldown - prices[i]);
            sold = oldHold + prices[i];
            cooldown = Math.max(oldCooldown, oldSold);
        }

        return Math.max(sold, cooldown);
    }
}
