/*
ID: audreyz1
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ariprog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int max=m*m*2;
        boolean[] all=new boolean[max+1];
        ArrayList<Integer> bisquares=new ArrayList<Integer>();
        for (int i=0; i<=m; i++) {
            for (int j=i; j<=m; j++) {
                all[i*i+j*j]=true;
                if (!bisquares.contains(i*i+j*j)) {
                    bisquares.add(i*i+j*j);
                }
            }
        }
        Collections.sort(bisquares);
        ArrayList<Sequence> sequences=new ArrayList<Sequence>();
        for (int i=0; i<bisquares.size()-n+1; i++) {
            for (int j=i; j<bisquares.size()-n+2; j++) {
                if (bisquares.get(i)!=bisquares.get(j)) {
                    int dif=bisquares.get(j)-bisquares.get(i);
                    int times = 1; int p=bisquares.get(i);
                    while (times<n) {
                        p += dif;
                        if (p>m*m*2) {
                            break;
                        } else {
                            if (!all[p]) {
                                break;
                            }
                            times++;
                        }
                    }
                    if (times>=n) {
                        sequences.add(new Sequence(bisquares.get(i), dif));
                    }
                }
            }
        }
        if (sequences.isEmpty()) {
            pw.println("NONE");
        } else {
            Collections.sort(sequences);
            for (int i = 0; i < sequences.size(); i++) {
                pw.println(sequences.get(i).start + " " + sequences.get(i).dif);
            }
        }
        pw.close();
    }

    static class Sequence implements Comparable<Sequence> {
        int start; int dif;
        public Sequence(int s, int d) {
            start=s;
            dif=d;
        }

        public int compareTo(Sequence s) {
            if (this.dif>s.dif) {
                return 1;
            } else if (this.dif==s.dif) {
                if (this.start>s.start) {
                    return 1;
                }
                return -1;
            }
            return -1;
        }
    }
}
