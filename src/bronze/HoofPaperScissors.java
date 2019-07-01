package bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HoofPaperScissors {
	static ArrayList<Integer[]> count(ArrayList<Integer[]> a) {
		for (int i=0; i<a.size(); i++) {
			Integer[] temp=a.get(i);
			if (temp[0]==1 && temp[1]==2) {
				a.remove(i);
			}
			else if (temp[0]==2 && temp[1]==3) {
				a.remove(i);
			}
			else if (temp[0]==3 && temp[1]==1) {
				a.remove(i);
			}
		}
		return a;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new FileReader("src/hps.in"));
		PrintWriter pw= new PrintWriter(new BufferedWriter(new FileWriter("src/hps.out")));
		String n=br.readLine();
		ArrayList<Integer[]> rounds=new ArrayList<Integer[]>();
		for (int i=0; i<Integer.parseInt(n); i++) {
			String[] temp=br.readLine().split(" ");
			Integer[] toAdd={Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
			if (toAdd[0]!=toAdd[1]) {
				rounds.add(toAdd);
			}
		}
		int osize=rounds.size();
		rounds=count(rounds);
		if (osize-rounds.size()>rounds.size()) {
			pw.println(osize-rounds.size());
		}
		else {
			pw.println(rounds.size());
		}
		pw.close();
	}
}
