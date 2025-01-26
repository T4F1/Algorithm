import java.util.*;
import java.io.*;

public class Main {

	static final String intro = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	static final String what = "\"재귀함수가 뭔가요?\"\n";
	static final String speech1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	static final String speech2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static final String speech3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static final String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static final String subfix = "라고 답변하였지.\n";
	static final String sub = "____";
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb.append(intro);
		recursion(N, 0);
		System.out.println(sb.toString());
	}
	
	private static void recursion(int N, int cnt) {
		StringBuilder SB = new StringBuilder();
		for(int i = 0; i < cnt; i++) {
			SB.append(sub);
		}
		
		sb.append(SB.toString()).append(what);
		if(N == 0) {
			sb.append(SB.toString()).append(answer);
			sb.append(SB.toString()).append(subfix);
			return;
		} else {
			sb.append(SB.toString()).append(speech1)
			.append(SB.toString()).append(speech2)
			.append(SB.toString()).append(speech3);
			recursion(N-1, cnt+1);
			sb.append(SB.toString()).append(subfix);
		}
	}
}
