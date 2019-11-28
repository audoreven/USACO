/*
ID: audreyz1
LANG: JAVA
TASK: friday
*/

import java.io.*;

public class friday {
    static int[] year1={0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

    static boolean isLeap(int year) {
        if (year%100==0 && year%400!=0) {
            return false;
        }
        if (year%4!=0) {
            return false;
        }
        return true;
    }

    static int[] rotate(int[] month) {
        for (int i=0; i<month.length; i++) {
            month[i]=(month[i]+1)%7;
        }
        return month;
    }

    static int[] rotateLeap(int[] month) {
        for (int i=0; i<month.length; i++) {
            month[i]=(month[i]+1)%7;
        }
        for (int i=2; i<month.length; i++) {
            month[i]=(month[i]+1)%7;
        }
        return month;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int year=Integer.parseInt(br.readLine());
        int[] days=new int[7];
        for (int i=0; i<12; i++) {
            days[year1[i]]++;
        }

        for (int i=1; i<year; i++) {
            int y=1900+i;
            if (isLeap(y)) {
                year1=rotateLeap(year1);
            }
            else {
                year1=rotate(year1);
            }
            for (int j=0; j<12; j++) {
                days[year1[j]]++;
            }
            if (isLeap(y)) {
                year1[0]=(year1[0]+1)%7;
                year1[1]=(year1[1]+1)%7;
            }
        }
        for (int i=0; i<6; i++) {
            pw.print(days[i]+" ");
        }
        pw.println(days[6]);
        pw.close();
    }
}
