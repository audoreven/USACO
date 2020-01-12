import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>();
        int[] p=new int[n+1];
        for (int i=0; i<=n; i++) {
            p[i]=i;
        }
        String breeds=br.readLine();
        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (breeds.charAt(a-1)==breeds.charAt(b-1)) {
                p[b]=p[a];
            } else {
                ArrayList<Integer> temp = edges.get(a);
                temp.add(b);
                edges.put(a, temp);
                temp = edges.get(b);
                temp.add(a);
                edges.put(b, temp);
            }
        }
    }

}

