package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static boolean[] visited = new boolean[8];
    static Queue<Integer> q = new LinkedList<>();


    // 인덱스를 1부터 시작 시키기위해서
    // 인덱스 1은 첫번째 노드에 연결된 노드들을 저장.
    static int[][] arr = {{}, {2,3}, {1, 3, 4}, {1,2,6},
            {2, 5}, {2, 4}, {3, 7}, {3, 6}};

    public static void main(String[] args) {
        bfs(1);
    }

    static void bfs(int start) {
        // 시작점을 큐에 넣는다. 1이 들어간다.
        q.add(start);

        // 방문처리 visited[1] = true
        visited[start] = true;

        // 방문처리했으면 큐에서 값을 하나 꺼내고 인접한 노드를 방문처리.
        // 큐에서 모든 원소를 꺼내면 탐색 종료
        while (!q.isEmpty()) {

            // 큐에서 값 꺼내고 출력 -> 1이 출력됨.
            int x = q.peek();
            q.poll();
            System.out.println(x);

            // 큐에서 꺼낸 원소의 인접한 노드들을 방문한다. arr[1].length
            //  => 1에 연결된 노드들(2, 3)
            for (int i = 0; i < arr[x].length; i++) {

                // i는 n번째 노드를 의미한다. 즉, 1은 첫번째 노드
                // arr[x][i]는 arr[][] = {{}, {2,3}, {1, 3, 4} ...
                // arr[1][0] -> 2, arr[1][1] -> 3
                int y = arr[x][i];

                // 방문
                if (!visited[y]){
                    visited[y] = true;
                    q.add(y);
                }
            }

        }
    }
}
