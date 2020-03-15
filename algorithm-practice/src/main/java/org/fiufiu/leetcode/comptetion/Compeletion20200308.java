package org.fiufiu.leetcode.comptetion;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Compeletion20200308 {

    public static void main(String[] args) {
//        Q2 test2 = new Compeletion20200308().new Q2();
//        int[] ints = {2,1,3,5,4};
//        int[] ints = {3,2,4,1,5};
//        int[] ints = {4,1,2,3};
//        int[] ints = {2,1,4,3,6,5};
//        int[] ints = {1,2,3,4,5,6};
//        System.out.println(test2.numTimesAllBlue(ints));

        Q3 test3 = new Compeletion20200308().new Q3();
//        n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]

//        int[] manager = {2, 2, -1, 2, 2, 2};
//        int[] informTime = {0, 0, 1, 0, 0, 0};
        int[] manager = {1,2,3,4,5,6,-1};
        int[] informTime = {0,6,5,4,3,2,1};
        int i = test3.numOfMinutes(7, 6, manager, informTime);
        System.out.println(i);
    }

    class Q1 {
        public String generateTheString(int n) {
            final char c1 = 'a';
            final char c2 = 'b';
            boolean the = false;
            if (n%2==0) {
                the = true;
                n = n-1;
            }
            StringBuilder s = new StringBuilder();
            for(int i=0; i<n; i++) {
                s.append(c1);
            }
            if (the) {
                s.append(c2);
            }
            return s.toString();
        }
    }

    class Q2 {
        public int numTimesAllBlue(int[] light) {
            int len=light.length;
            int max=light[0];
            int alr=0;
            int lower=0;
            int count=0;
            for (int i=0;i<len;i++) {
                lower++;
                if (max>light[i]){
                } else {
                    max=light[i];
                }
                if (max-alr-lower==0) {
                    count++;
                    lower=0;
                    alr=i+1;
                }
            }
            return count;
        }
    }

    class Q3 {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            int max=0;
            for(int i=0;i<n;i++) {
                if (informTime[i]==0) {
                    int j=i;
                    int time=0;
                    while(j!=headID) {
                        j=manager[j];
                        time=informTime[j]+time;
                    }
                    max = max>time?max:time;
                }
            }
            return max;
        }
    }


}
