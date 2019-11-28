/*
ID: audreyz1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beads {
    static char nextColor(char[] colors, int r, int dir) {
        boolean allwhite=true;
        for (int i=0; i<colors.length; i++) {
            if (colors[i]!='w') {
                allwhite=false;
            }
        }
        char c='w';
        if (!allwhite) {
            if (dir == 0) {
                int p = r + 1;
                if (p == colors.length) {
                    p = 0;
                }
                while (colors[p] == 'w') {
                    p++;
                    if (p == colors.length) {
                        p = 0;
                    }
                }
                c = colors[p];
            } else {
                int p = r - 1;
                if (p < 0) {
                    p = colors.length - 1;
                }
                while (colors[p] == 'w') {
                    p--;
                    if (p < 0) {
                        p = colors.length - 1;
                    }
                }
                c = colors[p];
            }
        }
        return c;
    }

    static int count(char[] colors, int breakpoint) {
        int beads=1; int length=colors.length-1;
        char prev=colors[breakpoint];
        int p=breakpoint+1;
        if (p>length) {
            p=0;
        }
        if (prev=='w') {
            prev=nextColor(colors, breakpoint, 0);
        }
        while (colors[p]==prev || colors[p]=='w') {
            beads++;
            p++;
            if (p>length) {
                p = 0;
            } if (beads==colors.length) {
                return colors.length;
            }
        } int ind=0;
        if (breakpoint==0) {
            prev=colors[length];
            p=length-1; ind=length;
        } else {
            prev = colors[breakpoint-1];
            p = breakpoint-2; ind=breakpoint-1;
            if (p<0) {
                p=length;
            }
        }
        beads++;
        if (prev=='w') {
            prev=nextColor(colors, ind, 1);
        }
        while (colors[p]==prev || colors[p]=='w') {
            beads++;
            p--;
            if (p<0) {
                p=length;
            }if (beads==colors.length) {
                return colors.length;
            }
        }
        if (beads>= colors.length) {
            return colors.length;
        }
        return beads;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int n=Integer.parseInt(br.readLine());
        String necklace=br.readLine();
        char[] colors= necklace.toCharArray();
        int[] beads=new int[n];
        for (int i=0; i<n; i++) {
            beads[i]=count(colors, i);
        }
        Arrays.sort(beads);
        pw.println(beads[n-1]);
        pw.close();
    }
}
