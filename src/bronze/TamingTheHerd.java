package bronze;

import java.util.Scanner;

public class TamingTheHerd {
	static int[] count(int[] arr) {
		int count=1;
		int count2=0;
		int lasttime=0;
		boolean[] checked=new boolean[arr.length];
		checked[0]=true;
		for (int i=1; i<arr.length; i++) {
			if (arr[i]==0) {
				count++;
				checked[i]=true;
			}
			else if (arr[i]>0) {
				checked[i]=true;
				if (lasttime!=Math.abs(arr[i]-i) && arr[i]<arr.length) {
					lasttime=Math.abs(arr[i]-i);
					count++;
				}
				for (int j=lasttime; j<i+1;j++) {
					checked[j]=true;
				}
			}
			else {
				checked[i]=false;
			}
		}
		for (int n=0; n<checked.length; n++) {
			if (checked[n]==false) {
				count2++;
			}
		}
		int[] breakoutnum={count, count2+count};
		return breakoutnum;
	}
	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		Scanner reader2=new Scanner(System.in);
		int days=reader.nextInt();
		int[] breakout=new int[days];
		String temp=reader2.nextLine();
		String[] dist=temp.split(" ");
		for(int i=0; i<days; i++) {
			breakout[i]=Integer.parseInt(dist[i]);
		}
		int[] numOfBreakout=count(breakout);
		System.out.println(numOfBreakout[0]+" "+numOfBreakout[1]);
		reader.close();
		reader2.close();
	}
}
