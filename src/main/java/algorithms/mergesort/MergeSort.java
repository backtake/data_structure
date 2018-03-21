package algorithms.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private List<Integer> array = new ArrayList<>();
    private int size;
    private int middleIndex;
    private List<Integer> tempMergedList = new ArrayList<>();

    /**
     * Sorts the given List in place
     * @param toSort the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> toSort) {
        if (toSort == null) throw new IllegalArgumentException("Nothing to be sorted");
        this.array = toSort;
        this.size = toSort.size();
        mergeSort(0, size-1);
    }

    private void mergeSort(int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            middleIndex = (lowIndex + highIndex) / 2;
            mergeSort(lowIndex, middleIndex);
            mergeSort(middleIndex+1, highIndex);
            mergeBothSides(middleIndex, highIndex);
        }
    }

    private void mergeBothSides(int middleIndex, int highIndex) {
        //copy array to temp array
        tempMergedList = new ArrayList<>(array);

        int i = 0;
        int j = middleIndex + 1;
        int k = 0;

        while (i<= middleIndex && j<=highIndex) {
            if (tempMergedList.get(i) <= tempMergedList.get(j)) {
                array.set(k, tempMergedList.get(i));
                i++;
            } else {
                array.set(k, tempMergedList.get(j));
                j++;
            }
            k++;
        }
        while (i <= middleIndex) {
            array.set(k, tempMergedList.get(i));
            k++;
            i++;
        }
        while (j <= highIndex) {
            array.set(k, tempMergedList.get(j));
            k++;
            j++;
        }
    }
}
