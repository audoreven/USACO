import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class MooyoMooyo {
    static int[] mx={1,0,-1,0};
    static int[] my={0,1,0,-1};

    static int[][] gravity(int[][] b) {
        for (int i=0; i<b[1].length; i++) {
            int[] temp=new int[b.length];
            int ind=0;
            for (int j=b.length-1; j>=0; j--) {
                if (b[j][i]==0) {
                    continue;
                } else {
                    temp[ind]=b[j][i];
                    ind++;
                }
            }
            int p=0;
            for (int j=b.length-1; j>=0; j--) {
                if (p>ind) {
                    b[j][i]=temp[p];
                }
            }
        }
        return b;
    }

    static boolean done(int[][] grid) {
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[][] board= new int[n][10];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(temp.substring(i, i + 1));
            }
        }
        while (!done(board)) {
            for (int i=n-1; i>=0; i--) {
                for (int j=9; j>=0; j--) {
                    if (board[i][j]!=0) {
                        Queue<Posi> q = new ArrayDeque<Posi>();
                        boolean[][] vis=new boolean[n][10];
                        q.add(new Posi(i,j));
                        //bfsCon
                    }

                }
            }
        }

    }
    static class Posi {
        int x,y;
        public Posi(int a, int b) {
            x=a;
            y=b;
        }
    }
}
