import java.util.*;
import java.io.*;

public class Main {

	private static final TreeMap<Integer, TreeMap<Integer, Integer>> DB = new TreeMap<>((o1, o2) -> {
		return o2 - o1;
	});
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			add(P, L);
		}
		
		int M = Integer.parseInt(br.readLine());
		String cmd;
		StringBuilder sb = new StringBuilder();
		int P, L, x;
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			if(cmd.equals("recommend")) {
				x = Integer.parseInt(st.nextToken());
				sb.append(recommend(x)).append("\n");
			} else if(cmd.equals("solved")) {
				P = Integer.parseInt(st.nextToken());
				solved(P);
			} else if(cmd.equals("add")) {
				P = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				add(P, L);
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	private static void add(int P, int L) {
		TreeMap<Integer, Integer> value;
		if(!DB.containsKey(L)) {
			value = new TreeMap<>((o1, o2) -> o2 - o1);
		} else {
			value = DB.get(L);
		}
		
		value.put(P, value.getOrDefault(P, 0) + 1);
		DB.put(L, value);
	}
	
	private static void solved(int P) {
		Set<Integer> keySet = DB.keySet();
		for(int key: keySet) {
			TreeMap<Integer, Integer> value = DB.get(key);
			if(!value.containsKey(P)) {
				continue;
			} else {
				if(value.get(P) > 2) {
					value.put(P, value.get(P) - 1);
				} else {
					value.remove(P);
				}
				
				if(value.isEmpty()) {
					DB.remove(key);
				}
				
				return;
			}
		}
		
		System.out.println("[SOLVED] 삭제할 문제가 없습니다.");
	}
	
	private static int recommend(int x) {
		if(x == 1) {
			int hardLev = DB.firstKey();
			TreeMap<Integer, Integer> value = DB.get(hardLev);
			return value.firstKey();
		}
		
		int easyLev = DB.lastKey();
		TreeMap<Integer, Integer> value = DB.get(easyLev);
		return value.lastKey();
	}
}
