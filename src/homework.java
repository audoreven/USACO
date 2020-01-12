import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class homework {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("homework.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] values=new int[n];
        int[] suffix=new int[n+1];
        int[] min=new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            values[i]= Integer.parseInt(st.nextToken());
        }
        min[n]=10001;
        for (int i=1; i<=n; i++) {
            suffix[n-i]=suffix[n-i+1]+values[n-i];
            min[n-i]=Math.min(min[n-i+1], values[n-i]);
        }
        long[] maxarr=new long[n-1]; long max=0;
        for (int i=n-2; i>=1; i--) {
            max=Math.max(max, (suffix[i]-min[i])/(n-i-1));
            maxarr[i]=(suffix[i]-min[i])/(n-i-1);
        }
        for (int i=0; i<n-1; i++) {
            if (maxarr[i]==max) {
                pw.println(i);
            }
        }
        pw.close();
    }
}
