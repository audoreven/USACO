/*
ID: audreyz1
LANG: JAVA
TASK: palsquare
*/

import java.io.*;

public class palsquare {
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
        BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int b=Integer.parseInt(br.readLine());
        String[] squares=new String[301];
        for (int i=1; i<301; i++) {
            convertBase(i*i,b);
            squares[i]=num;
            num="";
        }
        for (int i=1; i<301; i++) {
            if (checkPal(squares[i])) {
                convertBase(i,b);
                pw.println(num+" "+squares[i]);
                num="";
            }
        }
        pw.close();
    }
}
