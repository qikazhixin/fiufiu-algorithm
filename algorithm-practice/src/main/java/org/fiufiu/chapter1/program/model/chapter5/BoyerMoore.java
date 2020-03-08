package org.fiufiu.chapter1.program.model.chapter5;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class BoyerMoore {

    private int[] right;
    private String pat;

    public BoyerMoore(String pat) {
        this.pat = pat;

        int M = pat.length();
        int R=256;

        right=new int[R];
        for (int i=0;i<R;i++) {
            right[i]=-1;
        }
        for(int i=0;i<M;i++) {
            right[pat.charAt(i)]=i;
        }

    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i=0;i<N-M;i+=skip) {
            skip=0;
            for (int j=M-1;j>=0;j--) {
                if (pat.charAt(j)!=txt.charAt(i+j)) {
                    skip=j-right[txt.charAt(i+j)];
                    if (skip < 1) {
                        skip=1;
                    }
                    break;
                }
            }
            if (skip==0) {
                return i;
            }
        }
        return N;
    }
}
