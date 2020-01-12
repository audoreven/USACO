import java.io.*;
import java.util.StringTokenizer;

public class paintbarn {
    static int[][] barn= new int[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j=x1; j<x2; j++) {
                barn[j][y1]++;
                barn[j][y2]--;
            }
        }
        int ans=0;
        for (int i=0; i<1001;i++) {
            for (int j=0; j<1000; j++) {
                if (barn[i][j]==k) {
                    ans++;
                }
                barn[i][j+1]+=barn[i][j];
            }
        }
        pw.print(ans);
        pw.close();
    }
}
