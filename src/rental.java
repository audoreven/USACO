import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class rental {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rental.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] cows=new int[n];
        Shop[] shops=new Shop[m];
        int[] rent=new int[r];
        for (int i=0; i<n; i++) {
            cows[i]=Integer.parseInt(br.readLine());
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            shops[i]=new Shop(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for (int i=0; i<r; i++) {
            rent[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(cows);
        Arrays.sort(shops);
        Arrays.sort(rent);
        long earn=0;
        long[] prefix=new long[n+1]; int p=r-1;
        for (int i=n-1; i>0; i--) {
            if (p>=0) {
                prefix[i]+=rent[p];
                p--;
            }
            prefix[i-1]+=prefix[i];
        }
        long[] milk=new long[n+1]; p=0; long profit;
        for (int i=n-1; i>=0; i--) {
            if (p<m) {
                profit = 0;
                if (shops[p].need > cows[i]) {
                    profit += (cows[i] * shops[p].price);
                    shops[p].need -= cows[i];
                } else if (shops[p].need < cows[i]) {
                    while (p<m && cows[i]>0) {
                        if (cows[i]-shops[p].need>0) {
                            profit+=(shops[p].need*shops[p].price);
                            cows[i]-=shops[p].need;
                            p++;
                        } else if (cows[i]-shops[p].need<0) {
                            profit += (cows[i] * shops[p].price);
                            shops[p].need -= cows[i];
                            break;
                        } else {
                            profit += (cows[i] * shops[p].price);
                            p++;
                            break;
                        }
                    }
                } else {
                    profit += (cows[i] * shops[p].price);
                    p++;
                }
                milk[n-i] = profit;
            }
            milk[n-i] += milk[n - i-1];
        }
        for (int i=0; i<=n; i++) {
            earn=Math.max(earn, milk[i]+prefix[i]);
        }
        pw.print(earn);
        pw.close();
    }
    static class Shop implements Comparable<Shop> {
        int need; int price;
        public Shop(int i, int s) {
            need=i;
            price=s;
        }
        @Override
        public int compareTo(Shop o) {
            return o.price-this.price;
        }
    }
}
