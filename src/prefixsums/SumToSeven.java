package prefixsums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumToSeven {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] prefix=new int[n+1];
		for (int i=0; i<n; i++) {
			prefix[i]=prefix[i+1];
			prefix[i+1]+=(Integer.parseInt(br.readLine())%7);
		}
		int p=0; int q=n;
		while (p<q) {
			if (prefix[p+1]==prefix[q]){
				break;
			}
			p++;
			q--;
		}
		System.out.println(q-p);
	}
}
