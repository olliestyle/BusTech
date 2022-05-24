package ru.baib;

import java.util.Arrays;

public class BusTechInMemory<T extends Comparable<T>> {

    public T[] sort(T[] array, int start, int end) {
        int mid;
        if (start < end) {
            mid = (start + end) / 2;
            Arrays.sort(array, start, mid);
            Arrays.sort(array, mid, end + 1);
            if (mid == start) {
                return array;
            }
        } else {
            throw new IllegalArgumentException("Array boundaries are set incorrectly");
        }
        return merge(array, start, mid, end);
    }

    private T[] merge(T[] array, int start, int mid, int end) {
        for (int i = end; i >= mid; i--) {
            T last = array[mid - 1];
            int j;
            for (j = mid - 2; j >= start && array[j].compareTo(array[i]) > 0; j-- ) {
                array[j + 1] = array[j];
            }
            if (j != mid && last.compareTo(array[i]) > 0) {
                array[j + 1] = array[i];
                array[i] = last;
            }
        }
        return array;
    }
}
