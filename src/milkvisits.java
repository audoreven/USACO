import java.io.*;
import java.util.*;

public class milkvisits {
    static String breeds="";
    static Map<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] p=new int[n+1];
        for (int i=0; i<=n; i++) {
            p[i]=i;
        }
        breeds=br.readLine();
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
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            char h=st.nextToken().charAt(0);
            if (breeds.charAt(start-1)==h || breeds.charAt(end-1)==h) {
                pw.print(1);
            } else if (p[start]!=p[end]) {
                pw.print(1);
            } else {
                pw.print(0);
            }
        }
        pw.close();
    }

}
