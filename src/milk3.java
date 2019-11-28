/*
ID: audreyz1
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class milk3 {
    static boolean[][] searched = new boolean[21][21];
    static boolean[] amount = new boolean[21];
    static int a, b, c;
    static void pour(int x, int y, int z) {
        if (searched[x][y]) {
            return;
        }
        searched[x][y] = true;
        if (x == 0) {
            amount[z] = true;
        }
        if (x > 0 && y < b) {
            pour(Math.max(0, x + y - b), Math.min(b, x + y), z);
        }
        if (x > 0 && z < c) {
            pour(Math.max(0, x + z - c), y, Math.min(c, x + z));
        }
        if (y > 0 && x < a) {
            pour(Math.min(a, y + x), Math.max(0, y + x - a), z);
        }
        if (y > 0 && z < c) {
            pour(x, Math.max(0, y + z - c), Math.min(c, y + z));
        }
        if (z > 0 && x < a) {
            pour(Math.min(a, z + x), y, Math.max(0, z + x - a));
        }
        if (z > 0 && y < b) {
            pour(x, Math.min(b, z + y), Math.max(0, z + y - b));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        pour(0, 0, c);
        String ans="";
        for (int i = 0; i < 21; i++) {
            if (amount[i]) {
                ans+=i+" ";
            }
        }
        pw.println(ans.substring(0, ans.length()-1));
        pw.close();
    }
}
