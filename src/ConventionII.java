import java.io.*;
import java.util.*;

public class ConventionII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        PriorityQueue<Cow> wait=new PriorityQueue<Cow>(n, Cow::compareTo);
        wait.comparator();
        ArrayList<Cow> cows=new ArrayList<Cow>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            Cow temp= new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i+1);
            cows.add(temp);
            wait.add(temp);
        }
        Collections.sort(cows, new Comparator<Cow>() {
            public int compare(Cow o1, Cow o2) {
                if (o1.arrival>o2.arrival) {
                    return 1;
                } else if (o1.arrival==o2.arrival) {
                    if (o1.priority<o2.priority) {
                        return 1;
                    }
                }
                return -1;
            }
        });
        // simulate:
        int time=cows.get(0).arrival;
        int max=0;
        wait.add(cows.get(0));
        cows.remove(0);
        while (!cows.isEmpty()) {
            if (!wait.isEmpty()) {
                Cow curr = wait.poll();
                time += curr.time;
                while (cows.get(0).time <= time && !cows.isEmpty()) {
                    wait.add(cows.get(0));
                    max = Math.max(time - cows.get(0).arrival, max);
                    cows.remove(0);
                    if (cows.isEmpty()) {
                        break;
                    }
                }
            } else {
                wait.add(cows.get(0));
                cows.remove(0);
            }
        }
        pw.close();
    }
    static class Cow implements Comparable<Cow> {
        int arrival; int time; int priority;
        public Cow(int a, int t, int p) {
            arrival=a;
            time=t;
            priority=p;
        }

        public int compareTo(Cow o) {
            if (this.priority>o.priority) {
                return 1;
            }
            return -1;
        }
    }
}
