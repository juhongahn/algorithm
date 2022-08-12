package 정렬;

public class 계수정렬 {
    public static void main(String[] args) {
        int temp;
        // 데이터의 크기가 하나라도 10000이 나온다면 count[10000] 을 만들어줘야함..ㅠ
        int[] count = new int[5];
        int[] arr = {1, 3, 2, 4, 3, 2, 5, 3, 1, 2, 3, 4, 4, 3, 5, 1, 2, 3, 5, 2, 3, 1, 4, 3, 5, 1, 2, 1, 1, 1};

        for (int i = 0; i < 30; i++) {
            count[arr[i]-1]++;
        }

        for (int i = 0; i < 5; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    System.out.print((i + 1) +  " ");
                }
            }
        }
    }
}
