public class Main {

    static boolean[] team;
    static int[][] players;
    static int n;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        n = read();
        players = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                players[i][j] = read();
        team = new boolean[n];
        makeTeam(0, 0);
        System.out.println(minDiff);
    }

    private static void makeTeam(int depth, int p) {
        if (depth == n / 2) {
            int diff = calDiff();
            minDiff = Math.min(minDiff, diff);
            return;
        }
        for (int i = p; i < n; i++) {
            if (!team[i]) {
                team[i] = true;
                makeTeam(depth + 1, i + 1);
                team[i] = false;
            }
        }
    }

    private static int calDiff() {
        int teamA = 0, teamB = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (team[i] && team[j]) {
                    teamA += players[i][j];
                    teamA += players[j][i];
                } else if (!team[i] && !team[j]) {
                    teamB += players[i][j];
                    teamB += players[j][i];
                }
        return Math.abs(teamA - teamB);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}