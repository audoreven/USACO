package binarysearchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CityStates {
	// review
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Map<String, Long> count = new HashMap<String, Long>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String city = st.nextToken();
			String state = st.nextToken();
			if (!city.substring(0, 2).equals(state)) {
				String key = city.substring(0, 2) + state;
				if (!count.containsKey(key)) {
					count.put(key, 0L);
				}
				count.put(key, count.get(key) + 1);
			}
		}
		long interesting = 0;
		for (String key : count.keySet()) {
			String otherKey = key.substring(2) + key.substring(0, 2);
			if (count.containsKey(otherKey)) {
				interesting += count.get(key) * count.get(otherKey);
			}
		}
		System.out.println(interesting / 2);
	}

	static class City implements Comparable<City> {
		String city, state;

		public City(String a, String b) {
			city = a.substring(0, 2);
			state = b;
		}

		public int compareTo(City c) {
			if (this.city.equals(c.city)) {
				return this.state.compareTo(c.state);
			}
			return this.city.compareTo(c.city);
		}
	}
}
