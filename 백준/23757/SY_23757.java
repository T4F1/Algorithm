import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());
		
		PriorityQueue<Integer> presents = new PriorityQueue<>((o1, o2) -> o2 - o1);
		StringTokenizer inputPresent = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			presents.add(Integer.parseInt(inputPresent.nextToken()));
		}
		int[] child = new int[M];
		StringTokenizer inputChild = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			child[i] = Integer.parseInt(inputChild.nextToken());
		}
		
		int answer = 1;
		for(int i = 0; i < M; i++) {
			int present = presents.poll();
			int result = present - child[i];
			if(result < 0) {
				answer = 0;
				break;
			}
			presents.add(result);
		}
		
		System.out.println(answer);
		
		br.close();
	}
}
