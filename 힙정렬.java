package 정렬;

public class 힙정렬 {

    static int number = 9;
    static int heap[] = {7, 6, 5, 8, 3, 5, 9, 1, 6};

    public static void main(String[] args) {

        // 1부터 시작해서 힙을 만들어보자.
        // 최대 힙구조로 만들어준다. 이후 최상단과 root, 최하단 arr.length - 1을 바꾼다.
        for (int i = 1; i < number; i++) {
            int c = i;
            do {
                // 루트는 자기자신의 부모를 의미한다.
                // 완전 이진트리이므로 0 1 2 이렇게 있을 때 1과 2의 부모는
                // (1 - 1)  / 2 == 0, (2 - 1)  / 2 == 1/2, 즉 0
                int root = (c - 1) / 2;
                
                // 자식의 값이 부모의 것보다 크면 heapify해야함
                if (heap[root] < heap[c]) {
                    int temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                // 자식의 부모로 이동해서 또 heapify한다.
                c = root;
            } while (c != 0); // 최상단 루트에 다달으면 멈춤
        }
        // 크기를 줄여가며 반복적으로 힙을 만들어준다.
        for (int i = number - 1; i >= 0; i--) {

            // 최상단과 최하단을 바꿔준다.
            int temp1 = heap[0];
            heap[0] = heap[i];
            heap[i] = temp1;
            int root = 0;
            int c = 1;
            do {
                c = (2 * root) + 1;
                // 자식 중에 더 큰 값을 찾기, c는 i를 벗어나면 안된다. i는 정렬이 이미 끝난 상태
                if (c < i - 1 && heap[c] < heap[c + 1]) {
                    c++;
                }

                // 부모보다 자식이 더 크다면 교환
                if (c < i && heap[root] < heap[c]) {
                    int temp2 = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp2;
                }
                root = c;
            } while (c < i);
        }

        for (int i : heap) {
            System.out.println("i = " + i);
        }
    }
}
