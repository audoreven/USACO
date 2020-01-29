import java.io.*;
import java.util.StringTokenizer;

public class loan {
    static boolean work(long d, long x, long o, long m) {
        long have=0;
        for (int i=0; i<d; i++) {
            if (have<o) {
                if (((o-have)/x)>m) {
                    have+=((o-have)/x);
                } else {
                    have+=m;
                }
            }

        }

        return have<o;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("loan.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n=Long.parseLong(st.nextToken());
        long k=Long.parseLong(st.nextToken());
        long m=Long.parseLong(st.nextToken());
        long low=1; long high=(n/m)+1;
        while (low<high) {
            long mid=(low+high)/2;
            if (work(k,mid, n, m)) {
                high=mid;
            } else {
                low=mid+1;
            }
        }
        pw.println(low-1);
        pw.close();
    }
}
