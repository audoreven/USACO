import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        Point[] endpoints=new Point[2*n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            endpoints[i*2]=new Point(Integer.parseInt(st.nextToken()), true);
            endpoints[i*2+1]=new Point(Integer.parseInt(st.nextToken()), false);
        }
        Arrays.sort(endpoints);
        int total=0; int cur=0; int unique=Integer.MAX_VALUE; boolean streak=false;
        int start=0; boolean ustreak=false; int uni=0;
        // count total, count unique
        for (int i=0; i<2*n; i++) {
            if (endpoints[i].start) {
                cur++;
            } else {
                cur--;
            }
            // start streak
            if (cur>0 && !streak) {
                streak=true;
                start=endpoints[i].index;
            }else if (cur==0 && streak) {
                streak=false;
                total+=(endpoints[i].index-start);
            }
            if (cur==1 && !ustreak) {
                ustreak=true;
                uni=endpoints[i].index;
            } else if (cur!=1 && ustreak) {
                ustreak=false;
                unique=Math.min(endpoints[i].index-uni, unique);
            }
        }
        pw.println(total-unique);
        pw.close();
    }
    static class Point implements Comparable<Point> {
        int index; boolean start;
        public Point(int i, boolean s) {
            index=i;
            start=s;
        }
        @Override
        public int compareTo(Point o) {
            return this.index-o.index;
        }
    }
}
