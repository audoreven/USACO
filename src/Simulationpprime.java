/*
ID: audreyz1
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Simulationpprime {
    // find all prime palindromes
    static int[] firstlast={1,3,7,9};
    static ArrayList<Integer> primepals= new ArrayList<Integer>();
    static boolean isPrime(int n) {
        int root=(int) Math.sqrt(n);
        if (root*root==n) {
            return false;
        }
        for (int i=2; i<=root; i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
    static int findlength(int n, int l) {
        if (n==0) {
            return l;
        }
        return findlength(n/10, l+1);
    }
    //palindromes of length __
    static void generatelength2() {
        for (int i=0; i<4; i++) {
            int test=firstlast[i]*10+firstlast[i];
            if (isPrime(test)) {
                primepals.add(test);
            }
        }
    }
    static void generatelength3() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<=9; j++) {
                int test=firstlast[i]*100+j*10+firstlast[i];
                if (isPrime(test)) {
                    primepals.add(test);
                }
            }
        }
    }
    static void generatelength4() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<=9; j++) {
                int test=firstlast[i]*1000+j*100+j*10+firstlast[i];
                if (isPrime(test)) {
                    primepals.add(test);
                }
            }
        }
    }
    static void generatelength5() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<=9; j++) {
                for (int k=0; k<=9; k++) {
                    int test=firstlast[i]*10000+j*1000+k*100+j*10+firstlast[i];
                    if (isPrime(test)) {
                        primepals.add(test);
                    }
                }
            }
        }
    }
    static void generatelength6() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<=9; j++) {
                for (int k=0; k<=9; k++) {
                    int test=firstlast[i]*100000+j*10000+k*1000+k*100+j*10+firstlast[i];
                    if (isPrime(test)) {
                        primepals.add(test);
                    }
                }
            }
        }
    }
    static void generatelength7() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<=9; j++) {
                for (int k=0; k<=9; k++) {
                    for (int l=0; l<=9; l++) {
                        int test=firstlast[i]*1000000+j*100000+k*10000+l*1000+k*100+j*10+firstlast[i];
                        if (isPrime(test)) {
                            primepals.add(test);
                        }
                    }
                }
            }
        }
    }
    static void generatelength8() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<=9; j++) {
                for (int k=0; k<=9; k++) {
                    for (int l=0; l<=9; l++) {
                        int test=firstlast[i]*10000000+j*1000000+k*100000+l*10000+l*1000+k*100+j*10+firstlast[i];
                        if (isPrime(test)) {
                            primepals.add(test);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken()); int diga=findlength(a,0);
        int b=Integer.parseInt(st.nextToken()); int digb=findlength(b,0);
        primepals.add(5); primepals.add(7);
        if (b==100000000) {
            digb=8;
        }
        int gen=diga;
        while(gen<=digb) {
            if (gen==2) {
                generatelength2();
            } else if (gen==3) {
                generatelength3();
            } else if (gen==4) {
                generatelength4();
            } else if (gen==5) {
                generatelength5();
            } else if (gen==6) {
                generatelength6();
            } else if (gen==7) {
                generatelength7();
            } else if (gen==8) {
                generatelength8();
            }
            gen++;
        }

        for (int i=0; i<primepals.size(); i++) {
            if (primepals.get(i)>=a && primepals.get(i)<=b) {
                pw.println(primepals.get(i));
            }
            if (primepals.get(i)>b) {
                break;
            }
        }
        pw.close();
    }
}
