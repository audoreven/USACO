package dfsorbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GrassPlanting {
	// TREES 
	// REVIEW
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] patch= new int[n+1];
		for (int i=1; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			patch[a]++; 
			patch[b]++;
		}
		int ans=0;
		for (int i=0; i<n; i++) {
			ans=Math.max(ans, patch[i]);
		}
		System.out.println(ans+1);
	}
}
