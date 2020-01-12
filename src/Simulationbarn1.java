/*
ID: audreyz1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Simulationbarn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] occupied= new int[c];
        for (int i=0; i<c; i++) {
            occupied[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(occupied);
        int[] gaps=new int[c-1];
        for (int i=0; i<c-1; i++) {
            gaps[i] = occupied[i+1]-occupied[i]-1;
        }
        Arrays.sort(gaps);
        int ans=occupied[c-1]-occupied[0]+1;
        for (int i=0; i<m-1; i++) {
            if (c-2-i>=0) {
                ans -= gaps[c - 2 - i];
            }
        }
        pw.println(ans);
        pw.close();
    }
}
