import java.io.*;
import java.util.*;

public class helpcross {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        ArrayList<Integer> chickens=new ArrayList<Integer>();
        ArrayList<Times> cows=new ArrayList<Times>();
        for (int i=0; i<c; i++) {
            chickens.add(Integer.parseInt(br.readLine()));
        }
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            cows.add(new Times(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(chickens);
        Collections.sort(cows);
        int pairs=0;
        while (!cows.isEmpty() && !chickens.isEmpty()) {
            if (cows.get(0).start<=chickens.get(0) && chickens.get(0)<cows.get(0).end) {
                pairs++;
                cows.remove(0);
                chickens.remove(0);
            } else if (cows.get(0).start<=chickens.get(0) && chickens.get(0)>=cows.get(0).end) {
                cows.remove(0);
            } else if (cows.get(0).start>=chickens.get(0)) {
                chickens.remove(0);
            }
        }

        pw.println(pairs);
        pw.close();
    }
    static class Times implements Comparable<Times> {
        int start, end;
        public Times(int a, int b) {
            start =a;
            end =b;
        }

        public int compareTo(Times o) {
            if (this.start >o.start) {
                return 1;
            } else if (this.start ==o.start) {
                if (this.end >o.end) {
                    return 1;
                }
                return -1;
            }
            return -1;
        }
    }
}
