package zju.cst.hl.recursion;

/**
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 */
public class Number_698 {

    public static void main(String[] args) {

    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums != null && nums.length != 0){
            int sum = 0;
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length ; i++) {
                sum += nums[i];
                if(maxValue < nums[i]) maxValue = nums[i];
            }
            if(sum%k != 0 || maxValue > sum/k) return false;
            boolean[] isUsed = new boolean[nums.length];
            return function(isUsed,nums,k,sum/k,0,0);
        }

        return false;
    }

    public boolean function(boolean[] isUsed,int[] nums,int k,int target,int cur,int start){

        if(k == 0) return true;
        if(target == cur){
            return function(isUsed,nums,k-1,target,0,0);
        }
        /**
         * 这种写法值得深思，利用递归找到组合数
         */
        for (int i = start; i < nums.length ; i++) {
            if(!isUsed[i] && cur + nums[i] <= target){
                isUsed[i] = true;
                if(function(isUsed,nums,k,target,cur+nums[i],i+1)) return true;
                isUsed[i] = false;
            }
        }
        return false;
    }


    /**
     * 分析：k为分组个数 换句话说要找出它按照 k个分组的全部组合数 其中有一个
     *      满足要求就行
     *
     *      递归想法：f(k) = f(k - 1) = f(k - 2) = ....
     *      分组规模由k -> k-1 问题的本质在于 这个一个组合有多少种组合并且和为多少
     *
     *
     */


    /**
     * class Solution {
     *     private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
     *         // 返回条件
     *         if (k == 0) return true;
     *         if (cur == target) {
     *             // 构建下一个集合
     *             return backtracking(nums, k-1, target, 0, 0, used);
     *         }
     *         for (int i = start; i < nums.length; i++) {
     *             if (!used[i] && cur+nums[i] <= target) {
     *                 used[i] = true;
     *                 if (backtracking(nums, k, target, cur+nums[i], i+1, used)) return true;
     *                 used[i] = false;
     *             }
     *         }
     *         return false;
     *     }
     *
     *     public boolean canPartitionKSubsets(int[] nums, int k) {
     *         // 注意nums[i] > 0
     *         int sum = 0, maxNum = 0;
     *         for (int i = 0; i < nums.length; i++) {
     *             sum += nums[i];
     *             if (maxNum < nums[i]) maxNum = nums[i];
     *         }
     *         if (sum % k != 0 || maxNum > sum/k) return false;
     *         boolean[] used = new boolean[nums.length];
     *         return backtracking(nums, k, sum/k, 0, 0, used);
     *     }
     * }
     *
     */
}
