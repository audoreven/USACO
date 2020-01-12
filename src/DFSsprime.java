/*
ID: audreyz1
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class DFSsprime {
    // 1 dig primes
    static int[] onedigitprimes={2,3,5,7}; static int[] append={1,3,7,9};
    static int length=1;
    static ArrayList<Integer> superprimes=new ArrayList<Integer>();
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

    static void dfs(int n) {
        if (n>length) {
            if (isPrime(n)) {
                superprimes.add(n);
            }
            return;
        }
        for (int i=0; i<4; i++) {
            n=10*n+append[i];
            if (isPrime(n)) {
                dfs(n);
            }
            n/=10;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        int n=Integer.parseInt(br.readLine());
        for (int i=0; i<n-1; i++) {
            length*=10;
        }
        for (int i=0; i<4; i++) {
            dfs(onedigitprimes[i]);
        }
        Collections.sort(superprimes);
        for (int i=0; i<superprimes.size(); i++) {
            pw.println(superprimes.get(i));
        }
        pw.close();
    }
}
