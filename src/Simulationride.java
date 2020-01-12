/*
ID: audreyz1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Simulationride {
	// letters to numbers
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String comet=br.readLine();
		String group=br.readLine();
		int cometn=1;
		int groupn=1;
		for (int i=0; i<comet.length(); i++) {
			cometn=((int) comet.charAt(i)-64)*cometn;
		}
		cometn=cometn%47;
		for (int i=0; i<group.length(); i++) {
			groupn=((int) group.charAt(i)-64)*groupn;
		}
		groupn=groupn%47;

		if (cometn==groupn) {
			pw.println("GO");
		}
		else {
			pw.println("STAY");
		}
		pw.close();
	}
}
