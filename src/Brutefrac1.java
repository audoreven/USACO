/*
ID: audreyz1
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Brutefrac1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Fraction> fractions = new ArrayList<Fraction>();
        ArrayList<Fraction> ans = new ArrayList<Fraction>();
        fractions.add(new Fraction(0, 1));
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                fractions.add(new Fraction(i, j));
            }
        }
        Collections.sort(fractions);

        while (!fractions.isEmpty()) {
            if (fractions.size()>1) {
                double t1 = (double) fractions.get(0).numerator / fractions.get(0).denominator;
                double t2 = (double) fractions.get(1).numerator / fractions.get(1).denominator;
                while (t1 == t2) {
                    if (fractions.get(0).denominator < fractions.get(1).denominator) {
                        fractions.remove(1);
                    } else {
                        fractions.remove(0);
                    }
                    if (fractions.size() > 1) {
                        t1 = (double) fractions.get(0).numerator / fractions.get(0).denominator;
                        t2 = (double) fractions.get(1).numerator / fractions.get(1).denominator;
                    } else {
                        break;
                    }
                }
            }
            pw.println(fractions.get(0).numerator + "/" + fractions.get(0).denominator);
            fractions.remove(0);
        }
        pw.close();
    }

    static class Fraction implements Comparable<Fraction> {
        int numerator;
        int denominator;

        public Fraction(int x, int y) {
            numerator = x;
            denominator = y;
        }

        public int compareTo(Fraction o) {
            if ((double) this.numerator / this.denominator < (double) o.numerator / o.denominator) {
                return -1;
            } else if ((double) this.numerator / this.denominator == (double) o.numerator / o.denominator) {
                return 0;
            }
            return 1;
        }
    }
}
