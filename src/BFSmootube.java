import java.io.*;
import java.util.*;

public class BFSmootube {
    // bfs
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<Integer>());
        }
        int[][] relev = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            ArrayList<Integer> temp = edges.get(a);
            temp.add(b);
            edges.put(a, temp);
            temp = edges.get(b);
            temp.add(a);
            edges.put(b, temp);
            relev[a][b] = r;
            relev[b][a] = r;
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            // run bfs for every input
            int k = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            Queue<Integer> que = new ArrayDeque<Integer>();
            que.add(start);
            boolean[] vis = new boolean[n + 1];
            vis[start] = true;
            int count = 0;
            while (!que.isEmpty()) {
                int point = que.poll();
                if (!edges.get(point).isEmpty()) {
                    for (int j = 0; j < edges.get(point).size(); j++) {
                        int p=edges.get(point).get(j);
                        if (!vis[p]) {
                            vis[p] = true;
                            if (relev[point][p] >= k) {
                                que.add(p);
                                count++;
                            }
                        }
                    }

                }
            }
            pw.println(count);
        }
        pw.close();
    }
}
