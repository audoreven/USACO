import java.io.*;
import java.util.*;

public class lemonade {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans=0;
        int n=Integer.parseInt(st.nextToken());
        ArrayList<Integer> wait=new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int w=Integer.parseInt(st.nextToken());
            if (w>=n) {
                ans++;
            } else {
                wait.add(w);
            }
        }
        Collections.sort(wait);
        while (!wait.isEmpty()) {
            if (wait.get(0)>=ans) {
                ans++;
                wait.remove(wait.size()-1);
            } else {
                wait.remove(0);
            }
        }
        pw.println(ans);
        pw.close();
    }
}
