package org.fiufiu.chapter1.program.model.chapter5;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class LSD {

    public static void main(String[] args) {
        int[] te=new int[5];
        String[] ts={"4PGC938", "2IYE230", "3CI0720", "1ICK750"};
        sort(ts, 7);
        System.out.println(ts);
    }

    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d=w-1;d>=0;d--) {
            int[] count = new int[R+1];
            for (int i=0;i<N;i++) {
                count[a[i].charAt(d)+1]++;
            }
            for (int r=0;r<R;r++) {
                count[r+1]+=count[r];
            }
            for (int i=0;i<N;i++) {
                aux[count[a[i].charAt(d)]++]=a[i];
            }
            for (int i=0;i<N;i++) {
                a[i]=aux[i];
            }
        }

        /*//sort
        for (int i=w-1;i>=0;i--) {
            int[] count=new int[R+1];
            //init count
            for (int j=0;j<R+1;j++) {
                count[j]=-1;
            }
            //set count
            for (int j=0;j<N;j++) {

                count[aux[j].charAt(i)]++;
            }
            //set count into index
            int index=0;
            for (int j=0;j<R+1;j++) {
                if (count[j]==-1) {
                    continue;
                }
                int tmp=count[j];
                count[j]=index;
                index=index+tmp+1;
            }
            //set sort in aux
            for (int j=0;j<N;j++) {
                aux[count[a[j].charAt(i)]++]=a[j];
            }
            //return a
            for (int j=0;j<N;j++) {
                a[j]=aux[j];
            }
        }*/
    }
}
