import java.io.*;

public class ES_17478 {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        printMessage(0);
    }

    private static void printMessage(int x){
        System.out.println(space(x)+"\"재귀함수가 뭔가요?\"");
        if(x == n) {
            System.out.println(space(x)+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        }else{
            System.out.println(space(x)+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(space(x)+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(space(x)+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            printMessage(x+1);
        }
        System.out.println(space(x)+"라고 답변하였지.");
    }

    private static String space(int x){
        return "_".repeat(x*4);
    }
}
