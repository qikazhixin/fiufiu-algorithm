package org.fiufiu.chapter1.program.model.chapter5;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SonSearcher {

    public static int search(String pat, String txt) {
        int M=pat.length();
        int N=txt.length();
        for (int i=0;i<N-M;i++) {
            int j;
            for (j=0;j<M;j++) {
                if (pat.charAt(j)!=txt.charAt(i+j)) {
                    break;
                }
            }
            if (j==M) {
                return i;
            }

        }
        return N;
    }

    public static int search1(String pat, String txt) {
        int j,M=pat.length();
        int i,N=txt.length();
        for (i=0,j=0;i<N&&j<M;i++) {
            if (txt.charAt(i)==pat.charAt(j)) {
                j++;
                continue;
            } else {
                i -= j;
                j=0;
            }
        }
        if (j==M) return i-M;
        else return N;



    }
}
