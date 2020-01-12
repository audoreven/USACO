/*
ID: audreyz1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

public class Brutenamenum {
    // find name when given a number
    static String toInt(String s) {
        int l=s.length();
        String ret="";
        for (int i=0; i<l; i++) {
            char c=s.charAt(i);
            if (c=='A' || c=='B' || c=='C') {
                ret=ret+"2";
            } else if (c=='D' || c=='E' || c=='F') {
                ret=ret+"3";
            } else if (c=='G' || c=='H' || c=='I') {
                ret=ret+"4";
            } else if (c=='J' || c=='K' || c=='L') {
                ret=ret+"5";
            } else if (c=='M' || c=='N' || c=='O') {
                ret=ret+"6";
            } else if (c=='P' || c=='R' || c=='S') {
                ret=ret+"7";
            } else if (c=='T' || c=='U' || c=='V') {
                ret=ret+"8";
            } else {
                ret=ret+"9";
            }
        }
        return ret;
    }
    static HashMap<String, String> dict=new HashMap<String,String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String num = br.readLine();
        BufferedReader br1 = new BufferedReader(new FileReader("dict.txt"));
        String st;
        while ((st = br1.readLine()) != null) {
            if (st.length()==num.length()) {
                dict.put(st, toInt(st));
            }
        }
        boolean found = false;
        String[] keys=new String[dict.keySet().size()];
        dict.keySet().toArray(keys);
        Arrays.sort(keys);
        for (int i = 0; i < keys.length; i++) {
            if (dict.get(keys[i]).equals(num)) {
                pw.println(keys[i]);
                found = true;
            }
        }
        if (!found) {
            pw.println("NONE");
        }
        pw.close();
    }
}
