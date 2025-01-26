import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break; // 입력 종료 조건
            }

            int[] heights = new int[n + 1]; // 히스토그램 높이 배열
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            heights[n] = -1; // 마지막에 작은 값을 추가하여 스택 비우기 유도

            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1); // 초기 left 경계
            long maxArea = 0;

            for (int right = 0; right < heights.length; right++) {
                while (stack.size() > 1 && heights[right] < heights[stack.peek()]) {
                    int mid = stack.pop(); // 중심
                    int left = stack.peek(); // 왼쪽 경계
                    maxArea = Math.max(maxArea, (long) heights[mid] * (right - left - 1));
                }
                stack.push(right); // 현재 인덱스를 푸시
            }

            sb.append(maxArea).append("\n");
        }

        System.out.print(sb); // 결과 출력
    }
}