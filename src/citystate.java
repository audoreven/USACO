import java.io.*;
import java.util.*;

public class citystate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<String, Integer> number=new HashMap<String, Integer>();
        Set<String> pairs=new TreeSet<String>();
        int ans=0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String city=st.nextToken().substring(0,2);
            String state=st.nextToken().substring(0,2);
            if (pairs.contains(city+state)) {
                number.put(city+state, number.get(city+state)+1);
            } else {
                number.put(city+state, 1);
            }
            pairs.add(city+state);
        }
        for (String p: pairs) {
            String c=p.substring(0,2);
            String s=p.substring(2,4);
            if (pairs.contains(s+c) && !s.equals(c)) {
                ans+=(number.get(c+s)*number.get(s+c));
            }
        }
        pw.println(ans/2);
        pw.close();
    }
}
