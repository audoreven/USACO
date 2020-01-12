/*
ID: audreyz1
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class DFScrypt1 {
    static ArrayList<String> perm = new ArrayList<String>();
    static String num = "";

    static void dfs(int l, int ind) {
        if (num.length() == 5 || ind > 4) {
            perm.add(num);
            num = num.substring(0, ind);
            return;
        }
        for (int i = 1; i < l + 1; i++) {
            num = num.concat("" + i);
            dfs(l, ind + 1);
            num = num.substring(0, ind);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int i = 1; i < n + 1; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(set);
        int possible = 0;
        dfs(n, 0);
        for (int i = 0; i < perm.size(); i++) {
            int top = 0;
            int bot = 0;
            // top
            top = set.get(perm.get(i).charAt(0) - 49) * 100;
            top += set.get(perm.get(i).charAt(1) - 49) * 10;
            top += set.get(perm.get(i).charAt(2) - 49);
            int ps1 = set.get(perm.get(i).charAt(3) - 49)*top;
            int ps2 = set.get(perm.get(i).charAt(4) - 49)*top;
            String prod = "" + ((ps1*10)+ps2);

            if (prod.length() == 4 && ps1<1000 && ps2<1000 && ps1>99 && ps2>99) {
                boolean all = true;
                for (int j = 0; j < 4; j++) {
                    int digit=prod.charAt(j) - 48;
                    if (!set.contains(digit)) {
                        all = false;
                    }
                }
                for (int j=0; j<3; j++) {
                    int temp1=ps1%10;
                    int temp2=ps2%10;
                    if (!set.contains(temp1) || !set.contains(temp2)) {
                        all = false;
                    }
                    ps1 /=10;
                    ps2 /=10;
                }
                if (all) {
                    System.out.println(prod+" "+top+" "+(ps1+ps2)/top+" "+ps1+" "+ps2);
                    possible++;
                }
            }
        }

        pw.println(possible);
        pw.close();
    }
}
