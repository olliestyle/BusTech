package ru.baib;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BusTechExtraMemory<T extends Comparable<T>> {

    public T[] sort(Class<T> clazz, T[] array, int start, int end) {
        int mid;
        if (start < end) {
            mid = (start + end) / 2;
            Arrays.sort(array, start, mid);
            Arrays.sort(array, mid, end + 1);
        } else {
            throw new IllegalArgumentException("Array boundaries are set incorrectly");
        }
        return merge(clazz , array, start, mid, end);
    }

    private T[] merge(Class<T> clazz, T[] array, int start, int mid, int end) {
        T[] result = (T[]) Array.newInstance(clazz, array.length);
        for (int i = 0; i < start; i++) {
            result[i] = array[i];
        }

        T[] midArray = innerMerge(clazz,
                Arrays.copyOfRange(array, start, mid),
                Arrays.copyOfRange(array, mid, end + 1));

        for (int i = start; i <= end; i++) {
            result[i] = midArray[i - start];
        }


        for (int i = end + 1; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    private T[] innerMerge(Class<T> clazz, T[] left, T[] right) {
        T[] innerResult = (T[]) Array.newInstance(clazz, left.length + right.length);
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex + rightIndex < innerResult.length) {
            if (leftIndex == left.length || left.length == 0) {
                while (leftIndex + rightIndex < innerResult.length) {
                    innerResult[leftIndex + rightIndex] = right[rightIndex];
                    rightIndex++;
                }
                return innerResult;
            }
            if (rightIndex == right.length || right.length == 0) {
                while (leftIndex + rightIndex < innerResult.length) {
                    innerResult[leftIndex + rightIndex] = left[leftIndex];
                    leftIndex++;
                }
                return innerResult;
            }
            innerResult[leftIndex + rightIndex] = left[leftIndex].compareTo(right[rightIndex]) < 0 ? left[leftIndex++] : right[rightIndex++];
        }
        return innerResult;
    }

    public static void main(String[] args) {
        Integer[] arr = new BusTechExtraMemory<Integer>().sort(Integer.class, new Integer[]{9,8,7,6,5,4,3,2,1}, 2, 6);
        for(Integer i: arr) {
            System.out.print(i + " ");
        }
    }
}
