/*
ID: audreyz1
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.*;

public class DFSlamps {
    static Set<String> work = new HashSet<String>();
    static String test=""; static String a="";
    static void dfs(int[] lights, ArrayList<Integer> on, ArrayList<Integer> off, int lim) {
        if (test.length()==4) {
            int num1=0;
            for (int i=0; i<4; i++) {
                if (test.charAt(i) == '1') {
                    num1++;
                }
            }
            if (num1<=lim) {
                boolean okay = true;
                if (test.charAt(0) == '1') {
                    button1(lights);
                }
                if (test.charAt(1) == '1') {
                    button2(lights);
                }
                if (test.charAt(2) == '1') {
                    button3(lights);
                }
                if (test.charAt(3) == '1') {
                    button4(lights);
                }
                // check on
                for (int i = 0; i < on.size(); i++) {
                    if (lights[on.get(i)] != 1) {
                        okay = false;
                    }
                }
                // check off
                for (int i = 0; i < off.size(); i++) {
                    if (lights[off.get(i)] != 0) {
                        okay = false;
                    }
                }
                if (okay) {
                    for (int i = 1; i < lights.length; i++) {
                        a = a.concat("" + lights[i]);
                    }
                    work.add(a);
                    a = "";
                }
                for (int i = 1; i < lights.length; i++) {
                    lights[i] = 1;
                }
            }
            return;
        }
        for (int i=0; i<=1; i++) {
            test=test.concat(""+i);
            dfs(lights, on, off, lim);
            test=test.substring(0,test.length()-1);
        }
    }
    static int[] button1(int [] lights) {
        for (int i=1; i<lights.length; i++) {
            if (lights[i]==0) {
                lights[i]=1;
            } else {
                lights[i]=0;
            }
        }
        return lights;
    }
    static int[] button2(int [] lights) {
        for (int i=1; i<=lights.length/2; i++) {
            if (lights[i*2]==0) {
                lights[i*2]=1;
            } else {
                lights[i*2]=0;
            }
        }
        return lights;
    }
    static int[] button3(int [] lights) {
        for (int i=0; i<(lights.length)/2; i++) {
            if (lights[i*2+1]==0) {
                lights[i*2+1]=1;
            } else {
                lights[i*2+1]=0;
            }
        }
        return lights;
    }
    static int[] button4 (int [] lights) {
        for (int i=0; i<=(lights.length-1)/3; i++) {
            if (lights[i*3+1]==0) {
                lights[i*3+1]=1;
            } else {
                lights[i*3+1]=0;
            }
        }
        return lights;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken())%8;
        if (c>=4) {
            c/=2;
        }
        ArrayList<Integer> on = new ArrayList<Integer>();
        ArrayList<Integer> off = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        int add = Integer.parseInt(st.nextToken());
        while (add != -1) {
            on.add(add);
            add = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        while (add != -1) {
            off.add(add);
            add = Integer.parseInt(st.nextToken());
        }
        int[] lights= new int[n+1];
        for (int i=1; i<lights.length; i++) {
            lights[i]=1;
        }
        dfs(lights, on, off, c);
        if (work.isEmpty()) {
            pw.println("IMPOSSIBLE");
        } else {
            String[] all= new String[work.size()];
            work.toArray(all);
            Arrays.sort(all);
            for (int i=0; i<all.length; i++) {
                pw.println(all[i]);
            }
        }
        pw.close();
    }
}
