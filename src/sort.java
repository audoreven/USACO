import java.io.*;
import java.util.Arrays;

public class sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sort.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        int n=Integer.parseInt(br.readLine());
        int[] ori=new int[n];
        int[] sort=new int[n];
        int[] dis=new int[n];
        for (int i=0; i<n; i++) {
            ori[i]=Integer.parseInt(br.readLine());
            sort[i]=ori[i];
        }
        Arrays.sort(sort);
        boolean[] occ=new boolean[n];
        for (int i=0; i<n; i++) {
            int t=ori[i];
            int f=Arrays.binarySearch(sort, t);
            if (i-f>0) {
                while (sort[f+1]==t && f<i && !occ[f+1]) {
                    f++;
                }
            } else if (f-i>0) {
                while (sort[f-1]==t && i<f && !occ[f-1]) {
                    f--;
                }
            }
            dis[i]=Math.abs(i-f);
            occ[f]=true;
        }
        Arrays.sort(dis);
        pw.println(dis[n-1]+1);
        pw.close();
    }

}
