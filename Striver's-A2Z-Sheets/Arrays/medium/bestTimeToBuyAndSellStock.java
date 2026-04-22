/*
Problem: Best Time to Buy and Sell Stock (LC 121)
Constraint: Buy before sell, single transaction

─────────────────────────────────────────────
BRUTE FORCE
─────────────────────────────────────────────
Idea    : Try every (buy, sell) pair where buy < sell
TC      : O(n²)
SC      : O(1)
Use when: Never. Too slow for n = 10^5.
*/

// =============Approach 1 — Brute Force================
class Solution {
    public int maxProfit(int[] prices) {
        
        int bestProfit = 0;
        int n = prices.length;

        for (int i =  0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (prices[i] < prices[j]){
                    bestProfit = Math.max(bestProfit, prices[j] - prices[i]);
                }
            }
        }
        
        return bestProfit;
    }
}

/*
─────────────────────────────────────────────
OPTIMAL — Single Pass (Greedy)
─────────────────────────────────────────────
Idea    : Track minBuy so far. At each day, ask:
          "what's my profit if I sell TODAY?"
          Update maxProfit if it's better.
TC      : O(n)
SC      : O(1)
Use when: Always. Single transaction, maximize profit.

Core intuition: You can't go back in time.
                So track the cheapest price SEEN SO FAR
                and compute profit at every step forward.
*/

// =============Approach 2 Optimal. Single Pass (Greedy)================
class Solution2 {
    public int maxProfit(int[] prices) {
        
        int bestProfit = 0;
        int minBuy = Integer.MAX_VALUE;

        for (int num : prices){
            if (num < minBuy) minBuy = num;
            bestProfit = Math.max(bestProfit, num - minBuy);
        }
        
        return bestProfit;
    }
}