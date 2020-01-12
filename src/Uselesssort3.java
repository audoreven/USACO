/*
ID: audreyz1
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.Arrays;

public class Uselesssort3 {
    static int count=0;
    static void sort(int[] n1, int[] n2, int[] n3) {
        for (int i = 0; i < n1.length; i++) {
            if (n1[i] == 2) {
                // search both n2 and n3
                if (n2[0]==1) {
                    count++;
                    n2[0]=2; n1[i]=1;
                    Arrays.sort(n2);
                } else if (n3[0]==1) {
                    count++;
                    n3[0]=2; n1[i]=1;
                    Arrays.sort(n3);
                }
            } else if (n1[i] == 3) {
                // search both n2 and n3
                if (n3[0]==1) {
                    count++;
                    n3[0]=3; n1[i]=1;
                    Arrays.sort(n3);
                } else if (n2[0]==1) {
                    count++;
                    n2[0]=3; n1[i]=1;
                    Arrays.sort(n2);
                }
            }
        }
        for (int i=0; i<n3.length; i++) {
            if (n3[i]==2) {
                count++;
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        int[] num = new int[4];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
            num[sequence[i]]++;
        }
        int[] n1 = new int[num[1]];
        int[] n2 = new int[num[2]];
        int[] n3 = new int[num[3]];
        for (int i = 0; i < n; i++) {
            if (i < num[1]) {
                n1[i] = sequence[i];
            } else if (i < num[1] + num[2]) {
                n2[i - num[1]] = sequence[i];
            } else {
                n3[i - num[1] - num[2]] = sequence[i];
            }
        }
        Arrays.sort(n1);
        Arrays.sort(n2);
        Arrays.sort(n3);
        sort(n1, n2, n3);
        pw.println(count);
        pw.close();
    }
}
