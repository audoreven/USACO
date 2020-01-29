import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class wormsort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        Hole[] holes=new Hole[m];
        int[] cows=new int[n+1];
        st = new StringTokenizer(br.readLine());
        boolean okay=true;
        for (int i=1; i<=n; i++) {
            cows[i]=Integer.parseInt(st.nextToken());
            if (cows[i]<cows[i-1]) {
                okay=false;
            }
        }
        if (!okay) {
            pw.println(-1);
        } else {
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                holes[i]=new Hole(a,b,w);
            }
            Arrays.sort(holes);
        }

        pw.close();
    }
    static class Hole implements Comparable<Hole> {
        int start; int end; int width;
        Hole(int x, int y, int z) {
            start=x;
            end=y;
            width=z;
        }

        @Override
        public int compareTo(Hole o) {
            return this.width-o.width;
        }
    }
}
