import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class whereami {
    static HashSet<String> set=new HashSet<>();
    static boolean work(String s, int len) {
        for (int i=0; i<=s.length()-len; i++) {
            String sub=s.substring(i, i+len);
            if (set.contains(sub)) {
                set=new HashSet<>();
                return false;
            }
            if (!set.contains(sub)) {
                set.add(sub);
            }

        }
        set=new HashSet<>();
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        int n = Integer.parseInt(br.readLine());
        String mailbox=br.readLine();
        // binary search
        for (int i=1; i<=n; i++) {
            if (work(mailbox, i)) {
                pw.println(i);
                break;
            }
        }
        pw.close();
    }
}
