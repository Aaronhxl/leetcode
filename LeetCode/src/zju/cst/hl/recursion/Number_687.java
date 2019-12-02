package zju.cst.hl.recursion;

/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 */
public class Number_687 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode[] nodes = new TreeNode[6];
        nodes[0] = new TreeNode(1,null,null);
        nodes[1] = new TreeNode(1,null,null);
        nodes[2] = new TreeNode(4,nodes[1],nodes[0]);
        nodes[3] = new TreeNode(5,null,null);
        nodes[4] = new TreeNode(5,null,nodes[3]);
        nodes[5] = new TreeNode(5,nodes[2],nodes[4]);
        System.out.println(longestUnivaluePath(nodes[5]));

    }

    private static int max = 0;
    public static int longestUnivaluePath(TreeNode root) {
         if(root == null){
             return 0;
         }
         function(root);
         longestUnivaluePath(root.left);
         longestUnivaluePath(root.right);
         return max;
    }

    private static int function(TreeNode root) {
        if(root == null){
            return 0;
        }
        if((root.left != null && root.left.val == root.val) && (root.right != null && root.right.val == root.val)){
            int left = function(root.left) + 1;
            int right = function(root.right) + 1;
            int result = left + right;
            if(max < result){
                max = result;
            }
            return Math.max(left,right);
        }
        if(root.left != null && root.left.val == root.val){
            int left = function(root.left) + 1;
            if(max < left){
                max = left;
            }
            return left;
        }
        if(root.right != null && root.right.val == root.val){
            int right = function(root.right) + 1;
            if(max < right){
                max = right;
            }
            return right;
        }

        return 0;
    }


    /**
     * 分析一下：
     *      一个节点的最长同值路径是由它的子节点决定的
     *       即：如果与子节点的路径长度+1，不同则为0
     *
     *       其实就三种情况：
     *          以某个节点为根节点，那么它的最大同值长度一定是下面三种case
     *          1.左节点的val与它相等，那么它的最大同值长度为left + 1;
     *          2.右节点的val与它相等，那么它的最大同值长度为right + 1;
     *          3.左右绝不相等，则为0
     *       本题需要遍历全部的节点，故计算完本节点还需要往下继续计算，理论上可以用DP思想
     *       优化算法
     *
     *       做法：采用全局变量是一个选择
     *
     *       递归思想的核心在于从结果上去看问题，纠结于过程那么可能会陷入进去，虽然计算机的
     *       想法很简单，但它善于做重复性的工作，人的脑子复杂，但其实不擅长做重复性的工作
     *       所以某种意义上，我们其实并不能模拟出复杂递归的整个递归过程，从结果去看问题反而
     *       会更清晰，你的算法中需要什么，你应该咋样去实现，递归出口，递归函数的定义，一个
     *       递归编程高手都可以看到问题的本质
     *
     */


}
