import java.io.*;
import java.util.*;

public class test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayList<Integer>> same = new HashMap<Integer, ArrayList<Integer>>();
        Map<Integer, ArrayList<Integer>> dif = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            same.put(i + 1, new ArrayList<>());
            dif.put(i + 1, new ArrayList<>());
        }
        int[] pasture = new int[n + 1];
        int[] vis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if ("S".equals(st.nextToken())) {
                int temp = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());
                ArrayList<Integer> templ1 = same.get(temp);
                ArrayList<Integer> templ2 = same.get(temp2);
                if (templ1.size() > templ2.size()) {
                    same.put(temp2, templ1);
                    templ1.add(temp2);
                    same.put(temp, templ1);
                } else {
                    same.put(temp, templ2);
                    templ2.add(temp);
                    same.put(temp2, templ2);
                }
            } else {
                int temp = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());
                ArrayList<Integer> templ1 = dif.get(temp);
                ArrayList<Integer> templ2 = dif.get(temp2);
                templ1.add(temp2);
                templ2.add(temp);
                dif.put(temp, templ1);
                dif.put(temp2, templ2);
            }
        }
        // fill
        for (int i = 1; i <= n; i++) {
            if (vis[i]==0) {
                pasture[i]=1;
            }
            System.out.print("vis: ");
            for (int j=0; j<n; j++) {
                System.out.print(vis[j+1]+" ");
            }
            System.out.println();
            if (vis[i]==0) {
                if (!same.get(i).isEmpty()) {
                    vis[i] = 1;
                    for (int j = 0; j < same.get(i).size(); j++) {
                        if (vis[j] == 0) {
                            vis[j] = 1;
                            pasture[j] = pasture[i];
                        }
                    }
                }
                if (!dif.get(i).isEmpty()) {
                    vis[i] = 1;
                    for (int j = 0; j < dif.get(i).size(); j++) {
                        if (vis[j] == 0) {
                            vis[j] = 1;
                            System.out.println(i+": "+pasture[i]);
                            if (pasture[i] == 1) {
                                pasture[j] = 2;
                            } else {
                                pasture[j] = 1;
                            }
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i + 1] == 0) {
                count++;
            }
            System.out.print(pasture[i + 1] + " ");
        }
        System.out.print(1);
        for (int i = 0; i < count; i++) {
            System.out.print(0);
        }
        System.out.print(0);
    }
}
