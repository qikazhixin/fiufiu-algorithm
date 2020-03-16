package org.fiufiu.leetcode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
        System.out.println(diameter.diameterOfBinaryTree(diameter.create()));
    }

    private TreeNode create() {
        TreeNode node = new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        return node;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        ans=1;
        getTreeDep(root);
        return ans-1;
    }

    private int ans=0;
    private int getTreeDep(TreeNode node) {
        if (node==null) {
            return 0;
        }
        int ri = getTreeDep(node.right);
        int le=getTreeDep(node.left);
        int deNode = ri+le+1;
        ans=ans>deNode?ans:deNode;
        return Math.max(ri, le)+1;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
