import java.io.*;
import java.util.StringTokenizer;

public class fenceplan {
    static int[] p = new int[100001];
    static long[][] s = new long[100001][4];

    static int find(int n) {
        if (n == p[n]) {
            return n;
        }
        int a = find(p[n]);
        p[n] = a;
        return a;
    }

    static void union(int a, int b) {
        int l1 = find(a);
        int l2 = find(b);
        if (l1 == l2) {
            return;
        } else if (s[l1][1] > s[l2][1] || s[l1][3] > s[l2][3] || s[l1][2] < s[l2][2] || s[l1][0] < s[l2][0]) {
            p[l2] = l1;
            s[l1][0]=Math.min(s[l2][0], s[l1][0]);
            s[l1][1]=Math.max(s[l2][1], s[l1][1]);
            s[l1][2]=Math.min(s[l2][2], s[l1][2]);
            s[l1][3]=Math.max(s[l2][3], s[l1][3]);
        } else {
            p[l1] = l2;
            s[l2][0]=Math.min(s[l2][0], s[l1][0]);
            s[l2][1]=Math.max(s[l2][1], s[l1][1]);
            s[l2][2]=Math.min(s[l2][2], s[l1][2]);
            s[l2][3]=Math.max(s[l2][3], s[l1][3]);
        }
    }
    public static void main(String[] args) throws IOException {
        for (int i=0; i<100001; i++) {
            p[i]=i;
        }
        BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            long x=Integer.parseInt(st.nextToken());
            long y=Integer.parseInt(st.nextToken());
            s[i+1][0]=x;
            s[i+1][1]=x;
            s[i+1][2]=y;
            s[i+1][3]=y;
        }
        for (int i=0; i<m ;i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            union(a,b);
        }
        boolean[] vis=new boolean[n+1];
        long ans=Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            int test=find(i);
            if (!vis[test]) {
                vis[test]=true;
                ans=Math.min(ans, s[test][1]-s[test][0]+s[test][3]-s[test][2]);
            }
        }
        pw.print(ans*2);
        pw.close();
    }
}
