/*
ID: audreyz1
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class hamming {
    static ArrayList<String> attempt =new ArrayList<String>();
    static ArrayList<String> all =new ArrayList<String>();
    static String add="";

    static void dfs(int num, int dif) {
        if (add.length() >= num) {
            if (iwastesting(dif, add, add.length())) {
                attempt.add(add);
            }
            return;
        }
        for (int i = 0; i <=1; i++) {
            String append = ""+i;
            add=add.concat(append);
            dfs(num, dif);
            add = add.substring(0, add.length() - 1);
        }
    }

    static int binToInt(String bin) {
        int num=0;
        for (int i=0; i<bin.length(); i++) {
            int m=1;
            for (int j=0; j<i ;j++) {
                m*=2;
            }
            int n=(int) (bin.charAt(bin.length()-1-i)-48);
            num+=(n*m);
        }
        return num;
    }

    static boolean iwastesting(int ham, String maybe, int orilength) {
        for (int i=0; i<attempt.size(); i++) {
            int length=0;
            if (attempt.get(i).length()==orilength) {
                for (int j=0; j<orilength; j++) {
                    if (attempt.get(i).charAt(j)==maybe.charAt(j)) {
                        length++;
                    }
                }
            }
            if (orilength-length<ham) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        dfs(b,d);
        Collections.sort(attempt);
        String print="";
        int p=0;
        while (n>0) {
            print=""+binToInt(attempt.get(p*(10)));
            int plus=10;
            if (n<10) {
                plus=n;
            }
            for (int i=1+p*(10); i<plus+p*(10); i++) {
                print=print.concat(" "+binToInt(attempt.get(i)));
            }
            pw.println(print);
            p++;
            n-=plus;
        }
        pw.close();
    }
}
