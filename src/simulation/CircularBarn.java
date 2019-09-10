package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CircularBarn {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(br.readLine());
		ArrayList<Integer> cows=new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			cows.add(br.read());
		}
		int d=0;
		
	}
}
