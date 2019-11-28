/*
ID: audreyz1
LANG: JAVA
TASK: transform
*/

import java.io.*;

public class transform {
    static int transform=0;
    static boolean tryeverything(char[][] b, char[][] a) {
        b=one(b);
        if (same(b,a)) {
            transform=1;
            return true;
        }
        b=one(b);
        if (same(b,a)) {
            transform=2;
            return true;
        }
        b=one(b);
        if (same(b,a)) {
            transform=3;
            return true;
        }
        b=one(b);
        b=flip(b);
        if (same(b,a)) {
            transform=4;
            return true;
        }
            b=one(b);
            if (same(b,a)) {
                transform=5;
                return true;
            }
            b=one(b);
            if (same(b,a)) {
                transform=5;
                return true;
            }
            b=one(b);
            if (same(b,a)) {
                transform=5;
                return true;
            }
        return false;
    }
    static char[][] one(char[][] b) {
        int n=b.length;
        char[][] rotate=new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                rotate[i][j]=b[n-1-j][i];
            }
        }
        return rotate;
    }
    static char[][] flip(char[][] b) {
        int n=b.length;
        char[][] flip=new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                flip[i][n-1-j]=b[i][j];
            }
        }
        return flip;
    }
    static boolean same(char[][] b, char[][] a) {
        for (int i=0; i<b.length; i++) {
            for (int j=0; j<b.length; j++) {
                if (b[i][j]!=a[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("transform.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int n=Integer.parseInt(br.readLine());
        char[][] before=new char[n][n];
        char[][] after=new char[n][n];
        for (int i=0; i<n; i++) {
            before[i]=br.readLine().toCharArray();
        }
        for (int i=0; i<n; i++) {
            after[i]=br.readLine().toCharArray();
        }
        if (tryeverything(before, after)) {
            pw.println(transform);
        } else if (same(before, after)) {
            pw.println(6);
        } else {
            pw.println(7);
        }
        pw.close();
    }
}
