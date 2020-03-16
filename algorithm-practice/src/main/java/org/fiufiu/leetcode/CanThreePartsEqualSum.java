package org.fiufiu.leetcode;

public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        CanThreePartsEqualSum sum = new CanThreePartsEqualSum();
//        int[] ints = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int[] ints = {18,12,-18,18,-19,-1,10,10};
        System.out.println(sum.canThreePartsEqualSum(ints));
    }

    public boolean canThreePartsEqualSum(int[] a) {
        if(a.length<3) {
            return false;
        }
        int sum=0;
        for (int i=0;i<a.length;i++) {
            sum=sum+a[i];
        }
        if (sum%3!=0) {
            return false;
        }
        sum=sum/3;
        int tmp=sum;
        for (int i=0;i<a.length-2;i++) {
            tmp=tmp-a[i];
            if (tmp==0){
                int tmp1=sum;
                for (int j=i+1;j<a.length-1;j++) {
                    tmp1=tmp1-a[j];
                    if (tmp1==0) {
                        int tmp2=sum;
                        for (int k=j+1;k<a.length;k++) {
                            tmp2=tmp2-a[k];
                        }
                        if (tmp2==0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
