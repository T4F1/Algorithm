import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> weeks = new HashMap<>();
		Map<String, Integer> days = new HashMap<>();
		Map<String, Integer> moneys = new HashMap<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			weeks.put(name, Integer.parseInt(st.nextToken()));
			days.put(name, Integer.parseInt(st.nextToken()));
			moneys.put(name, Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int money = Integer.parseInt(st.nextToken());
			if(moneys.get(name) > money) {
				weeks.remove(name);
				days.remove(name);
				moneys.remove(name);
			}
		}
		
		List<Sunbae> sunbae = new ArrayList<>();
		for(String name : moneys.keySet()) {
			sunbae.add(new Sunbae(weeks.get(name), days.get(name), moneys.get(name)));
		}
		
		Collections.sort(sunbae, (o1, o2) -> {
			if(o1.week != o2.week) {
				return o1.week - o2.week;
			} else {
				return o1.day - o2.day;
			}
		});

		int maxCnt = 0;
		int cnt = 1;
		for(int i = 0; i < sunbae.size() - 1; i++) {
			if(sunbae.get(i).week == sunbae.get(i + 1).week) {
				if(sunbae.get(i).day == sunbae.get(i + 1).day) {
					continue;
				}
				if(sunbae.get(i).day + 1 == sunbae.get(i + 1).day) {
					cnt++;
				} else {
					if(maxCnt < cnt) {
						maxCnt = cnt;
					}
					cnt = 1;
				}
			} else if (sunbae.get(i).week + 1 == sunbae.get(i + 1).week){
				if(sunbae.get(i).day == 6 && sunbae.get(i + 1).day == 0) {
					cnt++;
				} else {
					if(maxCnt < cnt) {
						maxCnt = cnt;
					}
					cnt = 1;
				}
			} else {
				if(maxCnt < cnt) {
					maxCnt = cnt;
				}
				cnt  = 1;
			}
		}
		
		if(maxCnt < cnt) {
			maxCnt = cnt;
		}
		if(sunbae.size() == 1) {
			maxCnt = 1;
		} else if(sunbae.size() == 0) {
			maxCnt = 0;
		}
		
		System.out.println(maxCnt);
		
		br.close();
	}
	
	public static class Sunbae {
		int week;
		int day;
		int money;
		
		public Sunbae(int week, int day, int money) {
			this.week = week;
			this.day = day;
			this.money = money;
		}
	}
	
}
