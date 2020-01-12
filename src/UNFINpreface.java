/*
ID: audreyz1
LANG: JAVA
TASK: preface
*/

import java.io.*;

public class UNFINpreface {
    static void check() {

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("preface.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        int n = Integer.parseInt(br.readLine());
        String[] romannum=new String[n+1];
        romannum[1]="I"; romannum[5]="V"; romannum[10]="X"; romannum[50]="L";
        romannum[100]="C"; romannum[500]="D"; romannum[1000]="M";
        int I=0; int V=0; int X=0; int L=0; int C=0; int D=0; int M=0;
        for (int i=1; i<=n; i++) {
            // find roman numeral
            int thd=i/1000;
            int hd=(i%1000)/100;
            int td=(i%100)/10;
            int od=(i%10);

        }

        pw.close();
    }
}
