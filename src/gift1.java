/*
ID: audreyz1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int np=Integer.parseInt(br.readLine());
        String[] names=new String[np];
        HashMap<String, Integer> profit=new HashMap<>();
        for (int i=0; i<np; i++) {
            names[i]=br.readLine();
            profit.put(names[i],0);
        }

        for (int i=0; i<np; i++) {
            String giver=br.readLine();
            StringTokenizer st=new StringTokenizer(br.readLine());
            int price=Integer.parseInt(st.nextToken());
            int people=Integer.parseInt(st.nextToken());
            if (people!=0) {
                int gift = price / people;
                profit.replace(giver, -1 * price + profit.get(giver));
                for (int j = 0; j < people; j++) {
                    String person = br.readLine();
                    profit.replace(person, gift + profit.get(person));
                }
            }
        }
        for (int i=0; i<np; i++) {
            pw.println(names[i]+" "+(profit.get(names[i])));
        }
        pw.close();
    }*/
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("gift1.in"));
        PrintWriter pw = new PrintWriter(new File("gift1.out"));

        int np = sc.nextInt();
        List<String> people = new ArrayList<String>();
        for (int i = 0; i < np; i++) {
            people.add(sc.next());
        }

        Map<String, Integer> received = new HashMap<String, Integer>();
        for (String person : people) {
            received.put(person, 0);
        }
        Map<String, Integer> initial = new HashMap<String, Integer>();

        for (int i = 0; i < np; i++) {
            String person = sc.next();
            int amount = sc.nextInt();
            int recipients = sc.nextInt();

            initial.put(person, amount);

            int giftAmount = 0;
            if (recipients > 0) {
                giftAmount = amount / recipients;
                received.put(person, received.get(person) + amount % recipients);
            }
            for (int j = 0; j < recipients; j++) {
                String recipient = sc.next();
                received.put(recipient, received.get(recipient) + giftAmount);
            }
        }

        for (String person : people) {
            pw.println(person + " " + (received.get(person) - initial.get(person)));
        }

        pw.close();
    }
}
