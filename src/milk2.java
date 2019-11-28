/*
ID: audreyz1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Times[] times=new Times[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i]=new Times(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(times);
        int max2=0; int timestart=times[0].start; int timeend=times[0].end;
        int max1=timeend-timestart;

        for (int i=1; i<n; i++) {
            if (times[i].start<=timeend) {
                timeend=Math.max(times[i].end,timeend);
                max1=Math.max(timeend-timestart, max1);
            } else {
                timestart=times[i].start;
            }
            if (timestart>timeend) {
                max2=Math.max(timestart-timeend, max2);
                timeend=times[i].end;
            }
        }
        pw.println(max1+" "+max2);
        pw.close();
    }

    static class Times implements Comparable<Times> {
        int start; int end;
        public Times(int s, int e) {
            start=s;
            end=e;
        }
        public int compareTo(Times o) {
            if (this.start>o.start) {
                return 1;
            } else if (this.start==o.start) {
                if (this.end>o.end) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return -1;
        }
    }
}
