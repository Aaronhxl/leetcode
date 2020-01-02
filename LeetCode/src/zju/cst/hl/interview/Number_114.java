package zju.cst.hl.interview;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Number_114 {
    public static void main(String[] args) {

        TreeNode[] nodes = new TreeNode[6];
        nodes[0] = new TreeNode(3,null,null);
        nodes[1] = new TreeNode(4,null,null);
        nodes[2] = new TreeNode(2,nodes[0],nodes[1]);
        nodes[3] = new TreeNode(6,null,null);
        nodes[4] = new TreeNode(5,null,nodes[3]);
        nodes[5] = new TreeNode(1,nodes[2],nodes[4]);


        new Number_114().flatten(nodes[5]);

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

    public void flatten(TreeNode root) {

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> order = new Stack<>();
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                order.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                node = pop.right;
            }
        }

        TreeNode result = order.pop();
        result.left = result.right = null;
        //头插法构建链表
        while (!order.isEmpty()){
            TreeNode pop = order.pop();
            pop.left = null;
            pop.right = result;
            result = pop;
        }
        root = result;

        while (root != null){
            System.out.println(root.val);
            root = root.right;
        }
    }

    TreeNode lastNode = null;

    private TreeNode function(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode nodeRight = root.right;
        lastNode = root;
        root.right = function(root.left);
        root.left = null;
        lastNode.right = function(nodeRight);
        return root;
    }

    /**
     *  递归做法：需要记住其子节点
     *
     *
     */
}
