import java.io.*;
import java.util.StringTokenizer;

public class censor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[][] values=new int[n][n];
        int[][] best=new int[n][n];
        for (int i=0; i<n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                String val=st.nextToken().substring(0,1);
                if (val.equals("T")) {
                    values[i][j]=10;
                } else if (val.equals("J")) {
                    values[i][j]=11;
                } else if (val.equals("Q")) {
                    values[i][j]=12;
                } else if (val.equals("K")) {
                    values[i][j]=13;
                } else if (val.equals("A")) {
                    values[i][j]=1;
                } else {
                    values[i][j]=Integer.parseInt(val);
                }
                best[i][j]=values[i][j];
            }
        }
        for (int i=1; i<n; i++) {
            best[n-1][i]+=best[n-1][i-1];
        }
        for (int i=1; i<n; i++) {
            best[n-i-1][0]+=best[n-i][0];
        }
        for (int i=n-2; i>=0; i--) {
            for (int j=1; j<n; j++) {
                best[i][j]+=Math.max(best[i+1][j], best[i][j-1]);
            }
        }
        System.out.println(best[0][n-1]);
    }
}
