/*
ID: audreyz1
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.StringTokenizer;

public class AdHoccombo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("combo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fj={Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        int[] master={Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        if (n<=5) {
            // blah
            pw.println(n*n*n);
        }
        else {

            // look for exceptions
            int xdif=Math.abs(fj[0]-master[0]); int x=0;
            int ydif=Math.abs(fj[1]-master[1]); int y=0;
            int zdif=Math.abs(fj[2]-master[2]); int z=0;
            // for x
            if (xdif<=5) {
                x=5-xdif;
            } else if (xdif>=n-5) {
                x=5-(n-xdif);
            }
            // for y
            if (ydif<=5) {
                y=5-ydif;
            } else if (ydif>=n-5) {
                y=5-(n-ydif);
            }
            // for z
            if (zdif<=5) {
                z=5-zdif;
            } else if (zdif>=n-5) {
                z=5-(n-zdif);
            }
            pw.println(250-(x*y*z));
        }
        pw.close();
    }
}
