package org.fiufiu.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {

    @Test
    public void test() {
        generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);

    }


    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ls = new ArrayList<>();
        if (start>end) {
            ls.add(null);
            return ls;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generateTrees(start, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, end);
            for (TreeNode node1 : leftNodes) {
                for (TreeNode node2 : rightNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = node1;
                    treeNode.right = node2;
                    ls.add(treeNode);
                }
            }

        }
        return ls;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
