package algorithms.quicksort;

import java.util.List;

import static java.util.Collections.swap;

public class QuickSort {

    public void sort(List<Integer> toSort) {
        if (toSort == null) throw new IllegalArgumentException();
        quicksort(toSort, 0, toSort.size() - 1);
    }

    private void quicksort(List<Integer> toSort, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = toSort.get((left + right) / 2);
        int index = partition(toSort, left, right, pivot);
        quicksort(toSort, left, index - 1);
        quicksort(toSort, index, right);
    }

    private int partition(List<Integer> toSort, int left, int right, int pivot) {
        while (left <= right) {
            while (toSort.get(left) < pivot) {
                left++;
            }
            while (toSort.get(right) > pivot) {
                right--;
            }

            if (left <= right) {
                swap(toSort, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
