package 정렬;

/**
 * O(N^2)
 * 거의 정렬이 이루어진 배열에는 엄청 빨리 연산이 처리된다.
 */
public class 삽입정렬 {
    public static void main(String[] args) {

        int i, j, temp;
        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for (i = 0; i < 9; i++) {
            j = i;

            while (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j--;
            }
        }

        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
