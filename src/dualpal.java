/*
ID: audreyz1
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.StringTokenizer;

public class dualpal {
    static String num="";
    public static void convertBase(int number, int base) {
        if (number==0) {
            return;
        }
        int remainder=number%base;
        convertBase(number/base, base);
        if (remainder<10) {
            num=num+remainder;
        }
        else num=num+((char) (remainder-10+'A'));
    }
    static boolean checkPal(String num) {
        int p=0; int q=num.length()-1;
        while (q>p) {
            if (num.charAt(p)!=num.charAt(q)) {
                return false;
            }
            p++; q--;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int s= Integer.parseInt(st.nextToken());
        int times=0;
        int i=s+1;
        while (times<n) {
            int count=0;
            for (int j=2; j<=10; j++) {
                convertBase(i,j);
                if (checkPal(num)) {
                    count++;
                }
                num="";
            }
            if (count>=2) {
                times++;
                pw.println(i);
            }
            count=0;
            i++;
        }
        pw.close();
    }
}
