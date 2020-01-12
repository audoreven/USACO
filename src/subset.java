/*
ID: audreyz1
LANG: JAVA
TASK: subset
*/

import java.io.*;
import java.util.StringTokenizer;

public class subset {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("subset.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        int n=Integer.parseInt(br.readLine());
        int sum=((n)*(n+1))/2;
        if (sum%2==0) {
            int target=sum/2;
            int[][] dp=new int[n+1][n+1];
        } else {
            pw.println(0);
        }

    }
}
