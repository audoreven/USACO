import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class meetings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken())*2;
        ArrayList<Cow> cows = new ArrayList<Cow>();
        int barnweights=0;
        int totalweight=0;
        int mindif=Integer.MAX_VALUE;
        int m=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Cow a = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())*2, Integer.parseInt(st.nextToken()));
            cows.add(a);
            totalweight+=a.weight;
        }
        Collections.sort(cows);
        while(totalweight/2>barnweights) {
            for (int i=0; i<cows.size()-1; i++) {
                if (cows.get(i).dir==1 && cows.get(i+1).dir==-1) {
                    mindif=Math.min(mindif, Math.abs(cows.get(i).loci-cows.get(i+1).loci));
                }
            }
            // try mindif/2
            for (int i=0; i<cows.size()-1; i++) {
                cows.get(i).loci+=(cows.get(i).dir*mindif/2);
                cows.get(i+1).loci+=(cows.get(i).dir*mindif/2);
                if (cows.get(i).loci==cows.get(i+1).loci) {
                    cows.get(i).dir*=-1;
                    cows.get(i+1).dir*=-1;
                    m++;
                }
            }
            Collections.sort(cows);
            // check if any made to barns
            int ind=0;
            while (cows.get(ind).loci <= 0) {
                barnweights += cows.get(ind).weight;
                cows.remove(ind);
            }
            while (cows.get(ind).loci >= l) {
                ind = cows.size() - 1;
                barnweights += cows.get(ind).weight;
                cows.remove(ind);
            }
        }
        pw.println(m);
        pw.close();
    }

    static class Cow implements Comparable<Cow> {
        int loci;
        int weight;
        int dir;

        Cow(int w, int l, int d) {
            loci = l;
            weight = w;
            dir = d;
        }
        public int compareTo(Cow o) {
            return this.loci - o.loci;
        }
    }
}
