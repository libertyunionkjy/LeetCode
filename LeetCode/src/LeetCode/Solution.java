package LeetCode;
//dp[i][k][0]   第i天，没有持有股票、最多可以进行k笔交易
//状态：天数、最多进行几笔交易、是否持有股票
//没有持有股票：前一天就没持有、前一天卖掉了
//dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j][1] + price[i])
//持有股票：前一天持有、前一天买的
//dp[i][j][1] = max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i])

/**
 * 状态转移方程：
 * dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1] + price[i])
 * dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - price[i])
 * 初始化：i=-1代表还没有开始交易，还没有交易不可能持有股票
 * dp[-1][k][0]=0;dp[-1][k][1]=不可能（-infinity);
 * k=0代表不允许交易，不允许交易当然不可能持有股票
 * dp[i][0][0]=0;dp[i][0][1]=不可能（-infinity);
 * 通过状态转移方程可以看到dp[i][0][1]这种情况既不可能出现，也不会在求结果中使用到，所以可以省略对k的初始化
 * ①只能交易一次
 * dp[i][1][0]=max(dp[i-1][1][0],dp[i-1][1][1] + price[i])
 * dp[i][1][1]=max(dp[i-1][1][1],dp[i-1][0][0] - prices[i])
 * =max(dp[i-1][1][1],- prices[i])
 * -->与K无关
 * 状态转移方程
 * dp[i][0]=max(dp[i-1][0],dp[i-1][1] + price[i])
 * dp[i][1]=max(dp[i-1][1],-price[i])
 * -->初始化当i-1=-1的时候
 * dp[i][0]=0
 * dp[i][1]=-price[i]
 * -->优化空间复杂度
 * dp_i_0=0;
 * dp_i_1=-prices[0]
 * dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i])
 * dp_i_1=Math.max(dp_i_1,-prices[i])
 * ②不限制交易次数
 * dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
 * dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
 * ③只能交易两次
 * dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1] + prices[i])
 * dp[i][1][1]=Math.max(dp[i-1][1][1],- prices[i])
 * dp[i][2][0]=Math.max(dp[i-1][2][0],dp[i-1][2][1] + prices[i])
 * dp[i][2][1]=Math.max(dp[i-1][2][1],dp[i-1][1][0] - prices[i])
 * ④给定k值
 * 注意当k大于等于交易天数的1/2时，k相当于是没有限制的
 */
class Solution {
    public int maxProfit(int[] prices,int fee) {
        if(prices.length < 2)
            return 0;
        return maxProfit_infinityK_fee(fee, prices);
    }

    int maxProfit_infinityK(int[] prices){
        int day = prices.length;
        int i_0 = 0;
        int i_1 = -prices[0];
        for (int i = 1; i < day; i++) {
            i_0 = Math.max(i_0,i_1+prices[i]);
            i_1 = Math.max(i_1,i_0-prices[i]);
        }
        return i_0;
    }

    /**
     *
     * @param prices
     * @return
     * dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1] + price[i])
     * dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0] - price[i])
     */
    int maxProfit_infinityK_cool(int[] prices){
        int day = prices.length;
        int i_0 = 0;
        int i_1 = -prices[0];
        int i_pre_0 = 0;
        for (int i = 1; i < day; i++) {
            int tmp = i_0;
            i_0 = Math.max(i_0,i_1 + prices[i]);
            i_1 = Math.max(i_1,i_pre_0 - prices[i]);
            i_pre_0 = tmp;
        }
        return i_0;
    }
    int maxProfit_infinityK_fee(int fee, int[] prices){
        int day = prices.length;
        int i_0 = 0;
        int i_1 = -prices[0] - fee;
        for (int i = 1; i < day; i++) {
            int tmp = i_0;
            i_0 = Math.max(i_0,i_1 + prices[i]);
            i_1 = Math.max(i_1,tmp - prices[i] - fee);
        }
        return i_0;
    }
}
