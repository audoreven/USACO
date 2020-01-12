import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class lineup {
    //  Beatrice(1), Belinda(2), Bella (3), Bessie (4), Betsy (5), Blue (6), Buttercup (7), and Sue (8)
    static HashSet<String> set=new HashSet<>();
    static String add="";
    static ArrayList<String> work=new ArrayList<>();
    static boolean[] used={false, false, false, false, false, false, false, false, false};
    static void dfs(int num, int length) {
        if (add.length()==8) {
            set.add(add);
            return;
        }
        for (int i=1; i<=num; i++) {
            if (!used[i]) {
                used[i]=true;
                add = add.concat("" + i);
                dfs(num, length + 1);
                used[i]=false;
                add = add.substring(0, length);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] yes=new String[n];
        for (int i=0; i<n; i++) {
            String em="";
            st = new StringTokenizer(br.readLine());
            int c=0;
            String s=st.nextToken();
            if (s.equals("Beatrice")) {
                c=1;
            } else if (s.equals("Belinda")) {
                c=2;
            }else if (s.equals("Bella")) {
                c=3;
            }else if (s.equals("Bessie")) {
                c=4;
            }else if (s.equals("Betsy")) {
                c=5;
            }else if (s.equals("Blue")) {
                c=6;
            }else if (s.equals("Buttercup")) {
                c=7;
            }
            else if (s.equals("Sue")) {
                c=8;
            }
            em=em.concat(""+c);
            st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken();
            c=0;
            s=st.nextToken();
            if (s.equals("Beatrice")) {
                c=1;
            } else if (s.equals("Belinda")) {
                c=2;
            }else if (s.equals("Bella")) {
                c=3;
            }else if (s.equals("Bessie")) {
                c=4;
            }else if (s.equals("Betsy")) {
                c=5;
            }else if (s.equals("Blue")) {
                c=6;
            }else if (s.equals("Buttercup")) {
                c=7;
            }
            else if (s.equals("Sue")) {
                c=8;
            }
            em=em.concat(""+c);
            yes[i]=em;
            System.out.println(em);
        }
        dfs(8,0);
        String[] a=new String[set.size()];
        set.toArray(a);
        for (int i=0; i<a.length; i++) {
            boolean w=true;
            for (int j=0; j<n; j++) {
                String ye=yes[j].substring(1,2)+yes[j].substring(0,1);

                if (!a[i].contains(yes[j]) && !a[i].contains(ye)){
                    w=false;
                }
            }
            if (w) {
                work.add(a[i]);
            }
        }
        Collections.sort(work);
        String ans=work.get(0);
        for (int i=0; i<8; i++) {
            if (ans.charAt(i)=='1') {
                pw.println("Beatrice");
            } else if (ans.charAt(i)=='2') {
                pw.println("Belinda");
            }else if (ans.charAt(i)=='3') {
                pw.println("Bella");
            }else if (ans.charAt(i)=='4') {
                pw.println("Bessie");
            }else if (ans.charAt(i)=='5') {

                pw.println("Betsy");
            }else if (ans.charAt(i)=='6') {

                pw.println("Blue");
            }else if (ans.charAt(i)=='7') {
                pw.println("Buttercup");
            }
            else if (ans.charAt(i)=='8') {
                pw.println("Sue");
            }
        }
        pw.close();
    }
}
