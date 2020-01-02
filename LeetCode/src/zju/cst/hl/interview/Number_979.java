package zju.cst.hl.interview;

/**
 * https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/
 */
public class Number_979 {
    public static void main(String[] args) {

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int distributeCoins(TreeNode root) {
        function(root);
        return count;
    }

    private int count = 0;
    private int function(TreeNode root){
        if(root.left == null && root.right == null){
            if(root.val >= 1){
                count+= (root.val - 1);
                return root.val - 1;
            }else {
                count++;
                return -1;
            }
        }
        int valLeft = 0;
        int valRight = 0;
        if(root.left != null){
            valLeft = function(root.left);
        }
        if(root.right != null){
            valRight = function(root.right);
        }
        if(valLeft + valRight + root.val >= 1){
            return valLeft + valRight + root.val -1;
        }
        count+= Math.abs(valLeft+valRight+root.val - 1);
        return valLeft + valRight + root.val -1;
    }

    /**
     * 分析：二叉树 应该从底层开始分配金币，底层分配好了，再去分配高层
     *      递归的过程，底层如果有了，那么往上给
     *
     *      后续递归算法
     */
}

