package bronze;

import java.util.Scanner;

public class Teleportation {
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String temp=reader.nextLine();
		String[] num=temp.split(" ");
		Integer a=Integer.parseInt(num[0]);
		Integer b=Integer.parseInt(num[1]);
		Integer x=Integer.parseInt(num[2]);
		Integer y=Integer.parseInt(num[3]);
		int sum=0;
		if (a==b) {
			System.out.println(0);
		}
		if (a>b) {
			if (x>y){
				sum=Math.abs(a-x)+Math.abs(b-y)+sum;
			}
			else {
				sum=Math.abs(a-y)+Math.abs(b-x)+sum;
			}
		}
		else {
			if (x>y){
				sum=Math.abs(b-x)+Math.abs(a-y)+sum;
			}
			else {
				sum=Math.abs(b-y)+Math.abs(a-x)+sum;
			}
		}
		System.out.println(sum);
		reader.close();
	}
}
