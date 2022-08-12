package 정렬;

/**
 * O(N * logN)
 */
public class 퀵정렬 {
    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        quickSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void quickSort(int[] data, int start, int end) {
        // start가 end보다 크거나 같다는것은 피봇을 기준으로 분할한 배열의 원소가 1개인 경우를 의미함
        // {1} {2, 4, 5, ...}
        if (start >= end) {
            return;
        }

        // 피봇은 첫번째 원소
        int key = start;
        // 오른쪽으로 이동하면서 피봇보다 큰 값을 찾는 인덱스
        int i = start + 1;
        // 왼쪽으로 이동하면서 피봇보다 작은 값을 찾는 인덱스
        int j = end;

        // 값 변경을 위해 임시변수 temp설정
        int temp;

        // 엇갈릴 때 까지 반복, 엇갈리는 경우 피봇과 작은 값 arr[i]와 변경해준다.
        while (i <= j) {
            // 피봇보다 큰 값을 찾는 반복문, 큰 값을 찾으면 반복문 중단
            // 인덱스를 제한을 설정하지 않는 이유는
            // i와 j가 **엇갈리면 피봇과 인덱스 i의 값을 변경하기 떄문
            while (i <= end && data[i] <= data[key]) {
                i++;
            }

            // 피봇보다 작은 값을 찾는 반복문, 작은 값을 찾으면 반복문 중단
            // *** 중요: {1, 10, 4, ...} 1이 피봇이 된다면 오른쪽에서 출발한
            // 인덱스 j는 값을 못찾고 배열을 탈출.. -> j는 시작 인덱스보다 작아야한다.
            while (data[j] >= data[key] && j > start) {
                j--;
            }

            if (i > j) {    // 엇갈린경우 피봇과 작은 값의 자리를 바꿔준다
                temp = data[j];
                data[j] = data[key];
                data[key] = temp;
            } else {    // 엇갈리지 않은경우.
                        // (즉 피봇보다 작은값과 큰값의 자리를 변경(인덱스 안에서))
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }
        // 피봇을 기준으로 양옆에서 각각 정렬을 다시함.
        quickSort(data, start, j - 1);
        quickSort(data, j + 1, end);
    }
}
