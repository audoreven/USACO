package silver;

import java.util.ArrayList;
import java.util.Scanner;

public class ElectionTime {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String[] temp = reader.nextLine().split(" ");
		int cows = Integer.parseInt(temp[0]);
		int advance = Integer.parseInt(temp[1]);
		ArrayList<Integer[]> votes = new ArrayList<Integer[]>();
		ArrayList<Integer[]> votes2 = new ArrayList<Integer[]>();
		for (int i = 0; i < cows; i++) {
			String[] temp2 = reader.nextLine().split(" ");
			Integer[] x = { Integer.parseInt(temp2[0]), i + 1 };
			Integer[] y = { Integer.parseInt(temp2[1]), i + 1 };
			votes.add(x);
			votes2.add(y);
		}
		sortB(votes, votes.size(), 0);
		for (int i = 0; i < cows - advance; i++) {
			int check=votes.get(0)[1];
			votes.remove(0);
			System.out.println(check);
			for (int j = 0; j < votes2.size(); j++) {
				if (check == votes2.get(j)[1]) {
					votes2.remove(j);
					break;
				}
			}
		}
		sortB(votes2, votes2.size(), 0);
		System.out.println((votes2.get((votes2.size()) - 1)[1]));
	}

	public static void sortB(ArrayList<Integer[]> arr, int n, int k) {
		if (n > 0) {
			for (int i = 0; i < n - 1; i++) {
				if (arr.get(i)[0] > arr.get(i + 1)[0]) {
					Integer[] temp = arr.get(i + 1);
					arr.set(i + 1, arr.get(i));
					arr.set(i, temp);
				}
			}
			sortB(arr, n - 1, k);
		}
	}

}