package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// DELETE PACKAGE

public class FileReadersWritersETC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("REPLACE.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("REPLACE.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
	}
}
