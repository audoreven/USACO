package REVIEW;/*
ID: audreyz1
LANG: JAVA
TASK: REVIEW.skidesign
*/

import java.io.*;
import java.util.Arrays;

public class skidesign {
    // cannot greedy alg
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("REVIEW.skidesign.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("REVIEW.skidesign.out")));
        int n=Integer.parseInt(br.readLine());
        int[] hills=new int[n];
        for (int i=0; i<n; i++) {
            hills[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(hills);
        int cost=Integer.MAX_VALUE;
        //try all intervals
        for (int i=0; i<83; i++) {
            // interval i-i+17;
            int top=i+17;
            int c=0; int m=0;
            for (int j=0; j<n; j++) {
                if (hills[j]<i) {
                    m=i-hills[j];
                    c+=(m*m);
                }else if (hills[j]>top) {
                    m=hills[j]-top;
                    c+=(m*m);
                }
            }
            cost=Math.min(cost, c);
        }
        pw.println(cost);
        pw.close();
    }
}
