import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AlgorithmsTest {

    private Algorithms algorithms;
    private int[] unsortedArray;
    private int[] sortedArray;

    @BeforeEach
    public void setUp() {
        algorithms = new Algorithms();
        unsortedArray = new int[]{170, 45, 75, 90, 802, 24, 2, 66};  // Unsorted array
        sortedArray = new int[]{2, 24, 45, 66, 75, 90, 170, 802};   // Expected sorted array
    }

    @Test
    public void testHeapSort() {
        int[] arrayToTest = unsortedArray.clone();
        algorithms.heapSort(arrayToTest);
        assertArrayEquals(sortedArray, arrayToTest, "Heapsort should sort the array correctly.");
    }

    @Test
    public void testRandomizedQuickSort() {
        int[] arrayToTest = unsortedArray.clone();
        algorithms.randomizedQuickSort(arrayToTest, 0, arrayToTest.length - 1);
        assertArrayEquals(sortedArray, arrayToTest, "Randomized Quicksort should sort the array correctly.");
    }

    @Test
    public void testRadixSort() {
        int[] arrayToTest = unsortedArray.clone();
        algorithms.radixSort(arrayToTest);
        assertArrayEquals(sortedArray, arrayToTest, "Radix Sort should sort the array correctly.");
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = new int[]{};
        int[] expectedEmptyArray = new int[]{};

        // Test Heapsort
        algorithms.heapSort(emptyArray);
        assertArrayEquals(expectedEmptyArray, emptyArray, "Heapsort should handle empty arrays.");

        // Test Randomized Quicksort
        algorithms.randomizedQuickSort(emptyArray, 0, emptyArray.length - 1);
        assertArrayEquals(expectedEmptyArray, emptyArray, "Randomized Quicksort should handle empty arrays.");

        // Test Radix Sort
        algorithms.radixSort(emptyArray);
        assertArrayEquals(expectedEmptyArray, emptyArray, "Radix Sort should handle empty arrays.");
    }


    @Test
    public void testSingleElementArray() {
        int[] singleElementArray = new int[]{5};
        int[] expectedSingleElementArray = new int[]{5};

        algorithms.heapSort(singleElementArray);
        assertArrayEquals(expectedSingleElementArray, singleElementArray, "Heapsort should handle single element arrays.");

        algorithms.randomizedQuickSort(singleElementArray, 0, 0);
        assertArrayEquals(expectedSingleElementArray, singleElementArray, "Randomized Quicksort should handle single element arrays.");

        algorithms.radixSort(singleElementArray);
        assertArrayEquals(expectedSingleElementArray, singleElementArray, "Radix Sort should handle single element arrays.");
    }

    @Test
    public void testAlreadySortedArray() {
        int[] alreadySortedArray = sortedArray.clone();
        int[] expectedSortedArray = sortedArray.clone();

        algorithms.heapSort(alreadySortedArray);
        assertArrayEquals(expectedSortedArray, alreadySortedArray, "Heapsort should handle already sorted arrays.");

        algorithms.randomizedQuickSort(alreadySortedArray, 0, alreadySortedArray.length - 1);
        assertArrayEquals(expectedSortedArray, alreadySortedArray, "Randomized Quicksort should handle already sorted arrays.");

        algorithms.radixSort(alreadySortedArray);
        assertArrayEquals(expectedSortedArray, alreadySortedArray, "Radix Sort should handle already sorted arrays.");
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arrayWithDuplicates = new int[]{5, 3, 8, 3, 9, 5, 3, 8};
        int[] expectedSortedArrayWithDuplicates = new int[]{3, 3, 3, 5, 5, 8, 8, 9};

        int[] heapArray = arrayWithDuplicates.clone();
        algorithms.heapSort(heapArray);
        assertArrayEquals(expectedSortedArrayWithDuplicates, heapArray, "Heapsort should sort arrays with duplicates.");

        int[] quickArray = arrayWithDuplicates.clone();
        algorithms.randomizedQuickSort(quickArray, 0, quickArray.length - 1);
        assertArrayEquals(expectedSortedArrayWithDuplicates, quickArray, "Randomized Quicksort should sort arrays with duplicates.");

        int[] radixArray = arrayWithDuplicates.clone();
        algorithms.radixSort(radixArray);
        assertArrayEquals(expectedSortedArrayWithDuplicates, radixArray, "Radix Sort should sort arrays with duplicates.");
    }
}
