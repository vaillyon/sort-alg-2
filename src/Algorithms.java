import java.util.Arrays;
import java.util.Random;

public class Algorithms {


        // Heapsort
        public void heapSort(int[] arr) {
            int n = arr.length;

            // switch array
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }

            // get elements
            for (int i = n - 1; i >= 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr, i, 0);
            }
        }

        // Tree root w node
        private void heapify(int[] arr, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // left/ right child is larger than root
            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            // largest is not root
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                heapify(arr, n, largest);
            }
        }

        // Randomized Quicksort
        public void randomizedQuickSort(int[] arr, int low, int high) {
            if (arr == null || arr.length == 0) {
                return;
            }
            if (low < high) {
                int pi = randomizedPartition(arr, low, high);

                // recursive sort before, after partition
                randomizedQuickSort(arr, low, pi - 1);
                randomizedQuickSort(arr, pi + 1, high);
            }
        }
        // takes last element as pivot and puts in place
        private int randomizedPartition(int[] arr, int low, int high) {
            //  choose pivot
            Random rand = new Random();
            int pivotIndex = low + rand.nextInt(high - low + 1);

            // swap pivot with the last element
            int temp = arr[pivotIndex];
            arr[pivotIndex] = arr[high];
            arr[high] = temp;

            return partition(arr, low, high);
        }

        private int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                // it is smaller
                if (arr[j] <= pivot) {
                    i++;

                    // swap arr i and j
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // swap arr[i+1], high
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }

        // Radix Sort
        public void radixSort(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;  // empty
            }

            // get max num to find number of digits
            int max = Arrays.stream(arr).max().getAsInt();

            //  sort elements by value
            for (int exp = 1; max / exp > 0; exp *= 10) {
                countingSortByDigit(arr, exp);
            }
        }

    // counting sort of arr
    private void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // store occurrences in count[]
        for (int j : arr) {
            count[(j / exp) % 10]++;
        }

        // change count to give place in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy output array, has sorted numbers
        System.arraycopy(output, 0, arr, 0, n);
    }


        public static void main(String[] args) {
            Algorithms alg = new Algorithms();
            int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

            // heapsort
            int[] heapArr = arr.clone();
            alg.heapSort(heapArr);
            System.out.println("Heapsorted: " + Arrays.toString(heapArr));

            // randomized quicksort
            int[] quickArr = arr.clone();
            alg.randomizedQuickSort(quickArr, 0, quickArr.length - 1);
            System.out.println("Randomized Quicksorted: " + Arrays.toString(quickArr));

            // radix sort
            int[] radixArr = arr.clone();
            alg.radixSort(radixArr);
            System.out.println("Radix Sorted: " + Arrays.toString(radixArr));
        }
    }


