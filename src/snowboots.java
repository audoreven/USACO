import java.io.*;
import java.util.StringTokenizer;

public class snowboots {
    static int min = Integer.MAX_VALUE;
    static int b = 0;
    static int n = 0;
    static int[] depth = new int[251];
    static int[][] boots=new int[250][2];
    static boolean[][] vis=new boolean[251][251];

    static void dfs(int i, int b){
        if (vis[i][b]) return;
        vis[i][b] = true;

        if (i==n) {
            min = Math.min(min, b); return;
        }

        for (int i2=i+1; i2<n && i2-i<=boots[b][1]; i2++) {
            if (depth[i2]<=boots[b][1]) dfs(i2,b);
        }

        for (int b2=b+1; b2<b; b2++) {
            if (depth[i] <= boots[b2][0]) dfs(i, b2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int[] depth = new int[n + 1];
        int[][] boots = new int[b][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            depth[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            boots[i][0] = Integer.parseInt(st.nextToken());
            boots[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(min);
        pw.close();
    }
}
