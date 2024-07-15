public class Main {
        public static void quickSort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }

            int partitionIndex = partition(arr, l, r);

            quickSort(arr, l, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, r);
        }

        private static int partition(int[] arr, int l, int r) {
            int pivot = arr[r];
            int i = l - 1;

            for (int j = l; j < r; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int temp = arr[i + 1];
            arr[i + 1] = arr[r];
            arr[r] = temp;

            return i + 1;
        }

        public static void main(String[] args) {
            int[] arr = {10, 7, 8, 9, 1, 5};
            quickSort(arr, 0, arr.length - 1);

            System.out.println("Sorted array: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
}
