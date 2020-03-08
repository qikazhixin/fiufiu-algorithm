package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class PermutationGet {

    public static void main(String[] args) {
        PermutationGet permutation = new PermutationGet();
        String s = permutation.getPermutation(4, 9);
//        String s = permutation.getPermutation(3, 3);
//        String s = permutation.getPermutation(3, 4);
        System.out.println(s);
    }
/*
    // leetcode
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        List<Integer> nums = new ArrayList() {{add(1);}};

        factorials[0] = 1;
        for(int i = 1; i < n; ++i) {
            // generate factorial system bases 0!, 1!, ..., (n - 1)!
            factorials[i] = factorials[i - 1] * i;
            // generate nums 1, 2, ..., n
            nums.add(i + 1);
        }

        // fit k in the interval 0 ... (n! - 1)
        --k;

        // compute factorial representation of k
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > -1; --i) {
            int idx = k / factorials[i];
            k -= idx * factorials[i];

            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }*/


    public String getPermutation(int n, int k) {
        int[] count = new int[10];
        int[] step = new int[10];
        int[] ori = new int[n];
        for (int i=0;i<n;i++) {
            ori[i]=i+1;
        }
        count[1] = 1;
        count[0] = 1;
        for (int i=2;i<10;i++) {
            count[i] = i*count[i-1];
        }
        String s = "";
        int ind = n;
        int N = k;
        int st=1;
        while(ind > 0) {
            int i = (N - 1) / count[--ind];
            if (i<=0) {
                st++;
                continue;
            }
            step[st++]=i;
            N = N - i*(count[ind]);

        }
        for (int i=0;i<n;i++) {
            move(ori, i, step[i+1]);
        }

        for (int i=0;i<n;i++) {
            s=s+ori[i];
        }
        return s;
    }

    private void move(int[] ori, int start, int step){
        int tmp=ori[start+step];
        for (int i = start+step;i>start;i--) {
            ori[i]=ori[i-1];
        }
        ori[start]=tmp;
    }
}
