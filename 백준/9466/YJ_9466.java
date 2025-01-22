import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] pick = new int[n + 1][2];
			int[] team = new int[n + 1]; // 0: 미정 학생, 1: 이미 팀이 있는 학생, -1: 팀이 없는 학생

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				pick[i][0] = i;
				pick[i][1] = Integer.parseInt(st.nextToken());
				if (pick[i][0] == pick[i][1])
					team[i] = 1;
			}

			List<Integer> tmp = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				int start = pick[i][1];
				tmp.add(i);
				int cnt = 0;
				while (true) {
					if (cnt > n) { // 계속 순환될 때
						team[i] = -1;
						tmp.clear();
						break;
					}
					if (team[i] == 1) break; // 이미 팀이 있을 때
					if (team[start] != 0) { // 팀이 될 수 없을 때
						while (!tmp.isEmpty()) {
							int p = tmp.remove(0);
							if (team[p] != 1) 
								team[p] = -1;
						}
						break;
					}
					if (start == i) { // 팀이 될 수 있을 때
						while (!tmp.isEmpty()) {
							team[tmp.remove(0)] = 1;
						}
						break;
					}
					tmp.add(start);
					start = pick[start][1];
					cnt++;
				}
			}

			int teamCnt = 0;
			for (int i = 0; i <= n; i++) {
				if (team[i] == -1) {
					teamCnt++;
				}
			}
			sb.append(teamCnt).append("\n");
		}
		System.out.println(sb);
	}
}
