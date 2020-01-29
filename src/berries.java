import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class berries {
    static boolean work(ArrayList<Integer> b, int n) {
        int can=0;
        for (int i=0; i<b.size(); i++) {
            can+=b.get(i)/n;
        }
        return can>=b.size();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("berries.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        ArrayList<Integer> berries = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n;i++) {
            berries.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(berries);
        while (berries.size()>k) {
            berries.remove(0);
        }
        int ans=0;
        for (int i=0; i<k/2; i++) {
            ans+=berries.get(i);
        }
        // find avg of all

        pw.println(Math.max(0, ans));
        pw.close();
    }
}
