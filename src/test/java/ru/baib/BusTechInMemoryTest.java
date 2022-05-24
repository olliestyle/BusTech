package ru.baib;

import org.junit.Test;

import static org.junit.Assert.*;

public class BusTechInMemoryTest {

    @Test
    public void whenEntireArraySort() {
        BusTechInMemory<Integer> sorter = new BusTechInMemory<>();
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = sorter.sort(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 0, 8);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void whenDiapasonArraySort() {
        BusTechInMemory<String> sorter = new BusTechInMemory<>();
        String[] expected = {"g", "f", "b", "c", "d", "e", "a"};
        String[] actual = sorter.sort(new String[]{"g", "f", "e", "d", "c", "b", "a"}, 2, 5);
        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenException() {
        BusTechInMemory<Integer> sorter = new BusTechInMemory<>();
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = sorter.sort(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 3, 1);
        assertArrayEquals(expected, actual);
    }

}