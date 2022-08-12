package 정렬;

/**
 * 가장 비효율적인 정렬 알고리즘
 * O(N^2)
 */
public class 버블정렬 {
    public static void main(String[] args) {
        int i;
        int j;
        int temp = 0;
        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for (i = 0; i < 10; i++) {

            // 정렬이 뒤에서부터 시작된다. 9인 이유는 j+1 인덱스를 접근하기 때문
            for (j = 0; j < 9 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
