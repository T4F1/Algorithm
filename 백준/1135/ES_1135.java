import java.io.*;
import java.util.*;

public class ES_1135 {
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] maxValue;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        maxValue = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1)
                continue;
            graph.get(parent).add(i);
        }

        for(int i=n-1; i>=0; i--){
            List<Integer> children = graph.get(i);
            // 자식 노드가 없으면 continue
            if(children.size() == 0) continue;

            // 모든 자식들에 대해 maxValue 가져오기
            int[] nodeValue = new int[children.size()];
            for(int j=0; j<children.size(); j++){
                // 현재 자식이 갖는 maxValue의 값
                nodeValue[j] = maxValue[children.get(j)];
            }

            // 전화 돌리는 데 더 오래 걸리는 순으로 내림차순 정렬 (오름차순 정렬 후 역순 순회)
            Arrays.sort(nodeValue);

            int maxCount = 0;
            for(int j=children.size()-1; j>=0; j--){ // 순서대로 순회하면서 j 더해주고 maxCount 갱신하기
                maxCount = Math.max(maxCount, nodeValue[j] + (children.size()-j));
            }
            maxValue[i] = maxCount;
            answer = Math.max(answer, maxCount);
        }

        System.out.println(answer);
    }
}
