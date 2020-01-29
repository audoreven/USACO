import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    static int[] p = new int[100001];
    static long[][] s = new long[100001][4];

    static int find(int n) {
        if (n == p[n]) {
            return n;
        }
        int a = find(p[n]);
        p[n] = a;
        return a;
    }

    static void union(int a, int b) {
        int l1 = find(a);
        int l2 = find(b);
        if (l1 == l2) {
            return;
        } else if (s[l1][1] > s[l2][1] || s[l1][3] > s[l2][3] || s[l1][2] < s[l2][2] || s[l1][0] < s[l2][0]) {
            p[l2] = l1;
            s[l1][0]=Math.min(s[l2][0], s[l1][0]);
            s[l1][1]=Math.max(s[l2][1], s[l1][1]);
            s[l1][2]=Math.min(s[l2][2], s[l1][2]);
            s[l1][3]=Math.max(s[l2][3], s[l1][3]);
        } else {
            p[l1] = l2;
            s[l2][0]=Math.min(s[l2][0], s[l1][0]);
            s[l2][1]=Math.max(s[l2][1], s[l1][1]);
            s[l2][2]=Math.min(s[l2][2], s[l1][2]);
            s[l2][3]=Math.max(s[l2][3], s[l1][3]);
        }
    }
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
    static boolean work1(long d, long x, long o, long m) {
        long have=0; long day=d;
        // brute first few?
        long g=(o-have)/x;
        while ((o-have)/x>m && day>0) {
            // how many days to pay up g
            if (m>g) {
                g=m;
            }
            long p=(x/g);
            if (p==0) {
                p=1;
            }
            if (p>day) {
                p=day;
            }
            have+=(p*g);
            day-=p;
            System.out.println(" "+have+" "+day);
        }
        return have<o;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n=Long.parseLong(st.nextToken());
        long k=Long.parseLong(st.nextToken());
        long m=Long.parseLong(st.nextToken());
        long low=1; long high=(n/m)+1;
        while (low<high) {
            long mid=(low+high)/2;
            System.out.println(mid+": ");
            if (work1(k,mid, n, m)) {
                high=mid;
            } else {
                low=mid+1;
            }
        }
        System.out.println("WORK1: "+low);
        low=1; high=(n/m)+1;
        while (low<high) {
            long mid=(low+high)/2;
            if (work(k,mid, n, m)) {
                high=mid;
            } else {
                low=mid+1;
            }
        }
        System.out.println(low-1);
        //System.out.println(Math.max((s-1)*k/2, ans));
    }

}

