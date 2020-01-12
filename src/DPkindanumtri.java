/*
ID: audreyz1
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DPkindanumtri {
    // dp
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[][] tri=new int[n][n];
        int[][] best=new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<i+1; j++) {
                tri[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        best[0][0]=tri[0][0];
        for (int i=1; i<n; i++) {
            best[i][0]=best[i-1][0]+tri[i][0];
        }
        for (int i=1; i<n; i++) {
            for (int j=1; j<=i; j++) {
                best[i][j]=Math.max(tri[i][j]+best[i-1][j-1], tri[i][j]+best[i-1][j]);
            }
        }
        Arrays.sort(best[n-1]);
        pw.println(best[n-1][n-1]);
        pw.close();
    }
}
