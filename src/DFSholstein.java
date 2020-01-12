/*
ID: audreyz1
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;

public class DFSholstein {
    // dif scoops, finding out which ones to get to reach the amount needed
    static ArrayList<String> combos= new ArrayList<String>();
    static String combo="";
    static ArrayList<String> work=new ArrayList<String>();
    static void dfs(int scoops, int total, int prev) {
        if (combo.length() >= scoops) {
            combos.add(combo);
            return;
        }
        for (int i = prev+1; i <= total; i++) {
            String append = ""+i;
            if (i >= 10) {
                append = "" + ((char) ('A' + i - 10));
            }
            combo=combo.concat(append);
            dfs(scoops, total, i);
            combo = combo.substring(0, combo.length() - 1);
        }
    }

    static boolean work(int scoops, int[] min, int[][] amt) {
        dfs(scoops, amt.length-1, 0);
        for (int i=0; i<combos.size(); i++) {
            boolean okay=true;
            int[] sum=new int[min.length];
            for (int j=0; j<scoops; j++) {
                int row=(int) combos.get(i).charAt(j)-48;
                if (combos.get(i).charAt(j)>='A') {
                    row = (int) (combos.get(i).charAt(j) - 'A' + 10);
                }
                for (int k=1; k<min.length; k++) {
                    sum[k]+=amt[row][k];
                }
            }
            for (int j=1; j<min.length; j++) {
                if (min[j]>sum[j]) {
                    okay=false;
                }
            }
            if (okay) {
                work.add(combos.get(i));
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int[] vitamins = new int[v+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=v; i++) {
            vitamins[i]=Integer.parseInt(st.nextToken());
        }
        int s=Integer.parseInt(br.readLine());
        int[][] scoops=new int[s+1][v+1];
        for (int i=1; i<=s; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=v; j++) {
                scoops[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int min = 1;
        int max = s;
        if (max==1) {
            work.add("1");
        }
        while (min < max) {
            int mid = (min + max) / 2;
            if (work(mid, vitamins, scoops)) {
                max = mid;
            } else {
                min = mid+1;
            }
            combos=new ArrayList<String>();
        }

        Collections.sort(work,new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()) {
                    return 1;
                } else if (o1.length()==o2.length()) {
                    int o1sum=0; int o2sum=0;
                    for (int i=0; i<o1.length(); i++) {
                        if (o1.charAt(i)>='A') {
                            o1sum+=(int) (o1.charAt(i)-'A'+10);
                        } else{
                            o1sum+=o1.charAt(i)-48;
                        }
                        if (o2.charAt(i)>='A') {
                            o2sum+=(int) (o2.charAt(i)-'A'+10);
                        } else{
                            o2sum+=o2.charAt(i)-48;
                        }
                    }
                    if (o1sum>o2sum) {
                        return 1;
                    } else if (o1sum==o2sum) {
                        return 0;
                    }
                    return -1;
                }
                return -1;
            }
        });
        pw.print(min);
        if (min!=s) {
            char[] num = work.get(0).toCharArray();
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                if (num[i] >= 'A') {
                    pw.print(" " + (int) (num[i] - 'A' + 10));
                } else {
                    pw.print(" " + num[i]);
                }
            }
        } else {
            for (int i = 1; i <=min; i++) {
                pw.print(" "+i);
            }
        }
        pw.println();
        pw.close();
    }
}
