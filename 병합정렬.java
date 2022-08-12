package 정렬;

/**
 *
 * O(N * logN)
 */
public class 병합정렬 {

    // 병합 과정에서 추가적인 배열이 필요하다.
    static int[] sorted = new int[8]; // 정렬 배열은 반드시 멤버변수로 선언
    static int number = 8;

    public static void main(String[] args) {
        int[] array = {7, 6, 5, 8, 3, 5, 9, 1};
        mergeSort(array, 0, array.length-1);

        for (int a : array) {
            System.out.println(a);
        }
    }

    static void merge(int[] arr, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;

        // 작은순서대로 배열에 삽입.
        while (i <= middle && j <= n) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i];
                i++;
            } else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }
        // i나 j에 작은값들이 먼저 동이 난다면 반대 배열의 값을 그대로 sorted에 대입
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                sorted[k] = arr[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = arr[t];
                k++;
            }
        }
        // 정렬된 배열을 삽입.(반으로 나누고 병합하는 과정에서 임시 배열 sorted에 저장)
        // 이제 sorted에 저장된 정렬된 값을 배열에 옮기기
        for (int t = m; t <= n; t++) {
            arr[t] = sorted[t];
        }
    }

    // 병합정렬은 반으로 나누고 병합하는 과정으로 이어진다.
    static void mergeSort(int arr[], int m, int n) {
        if (m < n) {

            // 반으로 나누고
            int middle = (m + n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);

            // 나중에 합친다.
            merge(arr, m, middle, n);
        }
    }
}
