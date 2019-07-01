package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CowDanceShow {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("cowdance.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		String[] temp=br.readLine().split(" ");
		int n=Integer.parseInt(temp[0]);
		int Tmax=Integer.parseInt(temp[1]);
		ArrayList<Integer> showtimes=new ArrayList<Integer>(n);
		for (int i=0; i<n; i++) {
			showtimes.add(br.read());
		}
	}
}
