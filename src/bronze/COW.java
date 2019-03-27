package bronze;

import java.util.Scanner;

public class COW {
	static void unnamed() {
		//empty for now used to finetune this code lmao
	}
	static int findCows(String str) {
		int WCount=0; int number=0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i)=='C') {
				for (int j=i; j<str.length(); j++) {
					if (str.charAt(j)=='O') {
						for (int k=j; k<str.length(); k++) {
							WCount=0;
							if (str.charAt(k)=='W') {
								WCount++;
							}
							number=WCount+number;
						}
					}
				}
			}
		}
		return number;
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String phrase=reader.nextLine();
		System.out.println(findCows(phrase));
		reader.close();
		
	}
}
