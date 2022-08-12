package 정렬;

/**
 * O(N^2)의 시간복잡도를 가진다.
 */
public class 선택정렬 {
    public static void main(String[] args) {
        int i, j, min, idx = 0, temp;

        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        for (i = 0; i < 10; i++) {
            min = 9999;

            // 정렬이 끝난 인덱스는 순회하지 않는다.
            for (j = i; j < 10; j++) {

                // 배열을 순회하면서 가장 작은 원소를 찾는다.
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }

            // 가장 작은값을 찾았다면 제일 앞으로 보내준다.
            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
