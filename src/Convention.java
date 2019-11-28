import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Convention {
    static boolean possible(int w, int b, int max, int[] a) {
        int bus = 1;
        int first = a[0];
        int onbus = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - first > w || i+1-onbus > max) {
                bus++;
                first = a[i];
                onbus=i;
            }
        }
        if (bus <= b) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] arrive=new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arrive[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrive);
        // binary search
        int low=0; int high=arrive[n-1];
        while (low<high) {
            int mid=(low+high)/2;
            if (possible(mid, m, c, arrive)) {
                high=mid;
            } else {
                low=mid+1;
            }
        }
        pw.println(high);
        pw.close();
    }
}
