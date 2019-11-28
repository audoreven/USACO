package REVIEW;/*
ID: audreyz1
LANG: JAVA
TASK: REVIEW.wormhole
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class wormhole {
    static int total=0;

    static int loops(int[] pairs, int[] x, int[] y, int[] next) {
        for (int start=1; start<=pairs.length-1; start++) {
            int pos=start;
            for (int i=0; i<pairs.length-1; i++) {
                pos= next[pairs[pos]];

            }
            if (pos!=0) {
                return 1;
            }
        }
        return 0;
    }

    static void dfs(int[] pair, int[] x, int[] y, int[] next) {
        int n=pair.length-1; int i=0;
        for (i=1; i<=n; i++) {
            if (pair[i]==0) {
                break;
            }
        }
        if (i>n){
            total+=loops(pair, x, y, next);
        } else  {
           for (int j=1; j<=n; j++) {
               if (pair[j]==0 && i!=j) {
                   pair[i]=j;
                   pair[j]=i;
                   dfs(pair, x, y, next);
                   pair[i]=0;
                   pair[j]=0;

               }
           }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("REVIEW.wormhole.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("REVIEW.wormhole.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] xvalues= new int[n+1];
        int[] yvalues= new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            xvalues[i]=Integer.parseInt(st.nextToken());
            yvalues[i]=Integer.parseInt(st.nextToken());
        }
        int[] next=new int[n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (xvalues[j]>xvalues[i] && yvalues[j]==yvalues[i]) {
                    if (next[i]==0 || xvalues[j]<xvalues[next[i]]) {
                        next[i]=j;
                    }
                }
            }
        }
        int[] pairs= new int[n+1];
        dfs(pairs, xvalues, yvalues, next);

        pw.println(total);
        pw.close();
    }
}
