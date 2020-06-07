package org.fiufiu.exam.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Interview64 {

    public int sumNums(int n) {
        //学到的知识是

        boolean b = n > 0 && (n += sumNums(n -1)) > 0;
        return n;
    }
}
