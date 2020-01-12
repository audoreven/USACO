import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class gymnastic {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] ranks=new int[k][n];
        ArrayList<Integer>[] behind=new ArrayList[n+1];
        for (int i=0; i<=n ;i++) {
            behind[i]=new ArrayList<Integer>();
        }
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                ranks[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                behind[ranks[0][i]].add(ranks[0][j]);
            }
        }
        for (int i=1; i<k; i++) {
            for (int j=0; j<n; j++) {
                int start=ranks[i][j];
                ArrayList<Integer> be=new ArrayList<Integer>();
                for (int l=j+1; l<n; l++) {
                    be.add(ranks[i][l]);
                }
                for (int l=0; l<behind[start].size(); l++) {
                    if (!be.contains(behind[start].get(l))) {
                        behind[start].remove(l);
                        l--;
                    }
                }
            }
        }
        int ans=0;
        for (int i=1; i<=n; i++) {
            ans+=behind[i].size();
        }
        pw.println(ans);
        pw.close();
    }
}
