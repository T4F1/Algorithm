import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static HashMap<String,Integer> map = new HashMap<>();
	public static void main(String [] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String len = br.readLine();
			if(len.length()<M) {
				continue;
			}
			if(map.containsKey(len)) {
				map.put(len,map.get(len)+1);
			}else {
				map.put(len,0);
			}
		}
		List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            int freq1 = map.get(o1);
            int freq2 = map.get(o2);

            if (freq1 == freq2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2); // 알파벳 사전순
                } else {
                    return o2.length() - o1.length(); // 길이 기준 내림차순
                }
            } else {
                return freq2 - freq1; // 빈도 기준 내림차순
            }
        });
		for(String s: keySet) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}