package org.fiufiu.leetcode.comptetion;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Compeletion20200315 {

    public static void main(String[] args) {
        Compeletion20200315 test = new Compeletion20200315();
        test.test();
    }

    private void test() {
        Q1 q1 = new Q1();
        int[][] m = new int[][]{{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(q1.luckyNumbers(m));
    }

    class Q1 {
        public List<Integer> luckyNumbers (int[][] matrix) {
            int y = matrix.length;
            int x = matrix[0].length;
            //列最大
            int[] numL = new int[x];
            for(int j=0;j<x;j++) {
                numL[j]=matrix[0][j];
            }
            //横最小
            int[] numA = new int[y];
            for(int i=0;i<y;i++) {
                numA[i]=matrix[i][0];
            }
            for (int i=0;i<y;i++) {
                for (int j=0;j<x;j++) {
                    //先找横最小
                    numA[i]=Math.min(numA[i], matrix[i][j]);
                    //找列最大
                    numL[j]=Math.max(numL[j], matrix[i][j]);
                }
            }

            Set<Integer> collect = Arrays.stream(numA).mapToObj(value -> value).collect(Collectors.toSet());
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0;i<numL.length;i++) {
                if (collect.contains(numL[i])) {
                    list.add(numL[i]);
                }
            }
            return list;


        }
    }

    //Q2
    class CustomStack {

        int[] cantianer;
        int last;

        public CustomStack(int maxSize) {
            cantianer=new int[maxSize];
            last=-1;
        }

        public void push(int x) {
            if (last<cantianer.length-1) {
                cantianer[++last]=x;
            }
        }

        public int pop() {
            if (last>=0) {
                return cantianer[last--];
            }
            return -1;
        }

        public void increment(int k, int val) {
            k=Math.min(k, last+1);
            for (int i=0;i<k;i++) {
                cantianer[i]=cantianer[i]+val;
            }
        }
    }

    class Q3 {
        /*public TreeNode balanceBST(TreeNode root) {


        }

        private TreeNode balance(TreeNode node) {
            //如果node不平衡
            if (node)
            node.left=balance(node.left);
            node.right=balance(node.right);
            int le = deeps(node.left);
            int ri = deeps(node.right);
        }

        private int deeps(TreeNode node) {

        }*/
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
