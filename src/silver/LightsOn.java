package silver;

import java.util.Scanner;

public class LightsOn {
	static int x=1;
	static int y=1;
	static int count=1;
	static char lastM='n';
	static void next(boolean[][] OOO, int[][] lights) {
		lights=sort(lights, 3);
		System.out.println();
		for (int i=0; i<lights.length; i++) {
			for (int j=0; j<4; j++) {
				System.out.print(lights[i][j]+" ");
			}
			System.out.println();
		}
		boolean trap=false;
		while (trap==false){
			int tempx=x;
			int tempy=y;
			for (int i=0; i<OOO.length; i++) {
				for (int j=0; j<OOO.length; j++) {
					if (OOO[i][j]==true) {
						turnOnLights(i, j, lights, OOO);
					}
					lastM='n';
				}
			}
			// check if move or not
			if (tempx==x && tempy==y) {
				trap=true;
				break;
			} 
		}
	}
	static void turnOnLights(int m, int n, int[][] switches, boolean[][] OOO) {
		for (int i=0; i<switches.length; i++) {
			if (switches[i][0]==m+1 && switches[i][1]==n+1) {
				OOO[switches[i][2]-1][switches[i][3]-1]=true;
				count++;
			}
			move(OOO, switches[i][2], switches[i][3], lastM);
		}
		return;
	}
	static int[][] sort(int[][] n, int posi) {
		for (int i=0; i<n.length; i++) {
			for (int j=0; j<n.length-i-1; j++) {
				if (n[j+1][posi]<n[j][posi]) {
					int[] temp=n[j+1];
					n[j+1]=n[j];
					n[j]=temp;
				}
			}
		}
		if (posi==0){
			return n;
		}
		else {	
			return sort(n, posi-1);
		}
	}
	
	static void move(boolean[][] l, int tx, int ty, char last) {
		//SOMEHOW WRITE THIS STUFF THINKSDUOFHISDHKJF
		System.out.println(x+" "+y);
		if (tx==x && ty==y) {
			return;
		}
		// up
		if (x>1 && l[x-2][y-1]==true && last!='d') {
			x=x-1;
			lastM='u';
			move(l, tx, ty, lastM);
		}
		// left
		else if (y>1 && l[x-1][y-2]==true && last!='r') {
			y=y-1;
			lastM='l';
			move(l, tx, ty, lastM);
		}
		// down
		else if (x<l.length && l[x][y-1]==true && last!='u') {
			x=x+1;
			lastM='d';
			move(l, tx, ty, lastM);
		}
		// right
		else if (y<l.length && l[x-1][y]==true && last!='l') {
			y=y+1;
			lastM='r';
			move(l, tx, ty, lastM);
		}
		else {
			return;
		}
	}
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String temp=reader.nextLine();
		String[] num=temp.split(" ");
		Integer dimensions=Integer.parseInt(num[0]);
		Integer switches=Integer.parseInt(num[num.length-1]);
		boolean[][] onOrOff=new boolean[dimensions][dimensions];
		int[][] lights=new int[switches][4];
		for (int i=0; i<dimensions; i++) {
			for (int j=0; j<dimensions; j++) {
				onOrOff[i][j]=false;			
			}
		}
		onOrOff[0][0]=true;
		for (int i=0; i<switches; i++) {
			String next=reader.nextLine();
			String[] temp2=next.split(" ");
			for (int j=0; j<4; j++) {
				lights[i][j]=Integer.parseInt(temp2[j]);
			}
		}
		reader.close();
		
		next(onOrOff, lights);
		System.out.println(count);
	}
}
