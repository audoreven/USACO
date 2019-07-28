package silver;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumNumber {
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
        String[] temp=reader.nextLine().split(" ");
		int L=Integer.parseInt(temp[0]);
		int N=Integer.parseInt(temp[1]);
		String password=reader.nextLine();
		ArrayList<Integer> index=new ArrayList<Integer>();
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<Character> pswd=new ArrayList<Character>();
		for (int i=0; i<password.length(); i++) {
			pswd.add(password.charAt(i));
		}
		for (int i=0; i<L; i++) {
			if (password.charAt(i)=='?') {
				index.add(i);
			}
		}
		for (int i=0; i<N; i++) {
			list.add(reader.nextLine());
		}
		System.out.println(check(list, index, pswd));
	}
	
	static String check(ArrayList<String> list, ArrayList<Integer> index, ArrayList<Character> pswd) {
		int power=index.size();
		int num=1;
		for (int i=0; i<power; i++) {
			num=num*2;
		}
		num=num-1;
		for (int i=0; i<num; i++) {
			int[] binary=convertBinary(i, power);
			for (int j=0; j<index.size(); j++) {
				pswd.set(index.get(j), (char) (binary[power-1-j]+48));
			}
			String pass=ListtoString(pswd);
			// .contains
			if (contains(list, pass)) {
				return pass;
			}
				
		}
		return "NO SOLUTION";
	}
	
	static boolean contains(ArrayList<String> list, String pswd) {
		// check if things in list appear in pswd and then delete
		
		if (pswd==null) {
			return true;
		}
		return false;
	}
	
	static String ListtoString(ArrayList<Character> n) {
		StringBuilder builder = new StringBuilder(n.size());
	    for(int i=0; i<n.size(); i++) {
	        builder.append(n.get(i));
	    }
	    return builder.toString();
	}
	
	static int[] convertBinary(int number, int length) {
		int[] arr=new int[length];
		int count=0;
		while (number!=0) {
			int remainder=number%2;
			number=number/2;
			arr[count]= remainder;
			count++;
		}
		return arr;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	}
}
