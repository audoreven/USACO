import java.io.*;

public class moobuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        long n= Integer.parseInt(br.readLine());
        long ans=n*15/8;
        if (ans%5==0 || ans%3==0) {
            long t=ans-1;
            // n-1
            while (ans%5==0 || ans%3==0) {
                if (t-(t/3)-(t/5)+(t/15)==n && t%3!=0 && t%5!=0) {
                    ans=t;
                    break;
                }
                t--;
            }
            t=ans+1;
            while (ans%5==0 || ans%3==0) {
                if (t-(t/3)-(t/5)+(t/15)==n && t%3!=0 && t%5!=0) {
                    ans=t;
                    break;
                }
                t++;
            }
        }
        pw.println(ans);
        pw.close();
    }
}
