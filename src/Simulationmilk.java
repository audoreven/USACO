/*
ID: audreyz1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Simulationmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        Sale[] sales=new Sale[m];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            sales[i]=new Sale(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(sales);
        int need=n; int pay=0;
        for (int i=0; i<m; i++) {
            if (sales[i].units>=need) {
                pay +=sales[i].price*need;
                break;
            } else {
                need-=sales[i].units;
                pay += sales[i].price*sales[i].units;
            }
        }
        pw.println(pay);
        pw.close();
    }
    static class Sale implements Comparable<Sale> {
        int price; int units;
        public Sale(int p, int u) {
            price=p;
            units=u;
        }

        public int compareTo(Sale s) {
            if (this.price>s.price) {
                return 1;
            } else if (this.price==s.price) {
                return 0;
            }
            return -1;
        }
    }
}
