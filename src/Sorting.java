public class Sorting {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 2; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j > 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = key;
        }
    }

        public static void countingSort(int[] arr, int range) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[range + 1];

        for (int i = 0; i < n; i++) {
            int j = arr[i];
            count[j]++;
        }

        for (int i = 1; i <= range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int j = arr[i];
            //output[count[j] - 1] = arr[i]; tarzı olabilir
            //count[j]--;

            output[count[j] - 1] = arr[i];
            count[j]--;

        }

        System.arraycopy(output, 0, arr, 0, n);
    }


    /*

    public static void countingSort(int[] arr, int range) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[range + 1];

        for (int value : arr) {
            count[value]++;
        }

        for (int i = 1; i <= range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    */
    /*
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        mergeSort(arr);
        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }

    }

     */

    /*
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);
        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
     */
    /*
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr, 8);
        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
     */
}
