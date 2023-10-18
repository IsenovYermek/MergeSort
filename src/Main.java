public class Main {
    public static void main(String[] args) {
        int[] A = {5, 2, 4, 6, 1, 3, 2, 6};
        int length = A.length;

        sort(A, 0, length - 1);

        for (int i = 0; i < length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = Math.round((p + r) / 2);
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = A[q + 1 + j];
        }

        // Добавляем "бесконечность" в конце каждого массива для обработки конца массива
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (leftArray[i] <= rightArray[j]) {
                A[k] = leftArray[i];
                i++;
            } else {
                A[k] = rightArray[j];
                j++;
            }
        }
    }
}