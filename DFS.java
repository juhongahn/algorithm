package dfs;

public class DFS {

    static boolean[] visited = new boolean[8];
    static int[][] arr = {{}, {2,3}, {1, 3, 4}, {1,2,6},
            {2, 5}, {2, 4}, {3, 7}, {3, 6}};

    static void dfs(int x) {
        // 파라미터로 넘어온 인덱스가 방문된 인덱스라면
        if (visited[x]) return;

        // 처음 방문하는거라면
        visited[x] = true;
        System.out.printf("%d ", x);

        // 해당 인덱스와 붙어있는 노드
        for (int i = 0; i < arr[x].length; i++) {

            // 인접노드
            int y = arr[x][i];
            dfs(y);
        }

    }


    public static void main(String[] args) {
        dfs(1);
    }
}
