package ru.baib;

import org.junit.Test;

import static org.junit.Assert.*;

public class BusTechExtraMemoryTest {

    @Test
    public void whenEntireArraySort() {
        BusTechExtraMemory<Integer> sorter = new BusTechExtraMemory<>();
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = sorter.sort(Integer.class, new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 0, 8);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void whenDiapasonArraySort() {
        BusTechExtraMemory<String> sorter = new BusTechExtraMemory<>();
        String[] expected = {"g", "f", "b", "c", "d", "e", "a"};
        String[] actual = sorter.sort(String.class, new String[]{"g", "f", "e", "d", "c", "b", "a"}, 2, 5);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void whenDiapason2ArraySort() {
        BusTechExtraMemory<String> sorter = new BusTechExtraMemory<>();
        String[] expected = {"g", "f", "d", "e", "c", "b", "a"};
        String[] actual = sorter.sort(String.class, new String[]{"g", "f", "e", "d", "c", "b", "a"}, 2, 3);
        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenException() {
        BusTechExtraMemory<Integer> sorter = new BusTechExtraMemory<>();
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = sorter.sort(Integer.class, new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 3, 1);
        assertArrayEquals(expected, actual);
    }

}