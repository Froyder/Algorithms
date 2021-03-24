package javaAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

    //пирамидальная сортировка

    private static int heapSize;

    public static void sort (int [] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap (a, 0, heapSize - 1);
            heapSize--;
            heapify (a, 0);
        }
    }

    public static void buildHeap (int [] a) {
        heapSize = a.length;
        for (int i = a.length /2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    public static void heapify (int [] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && a[i] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a [r]) {
            largest = r;
        }
        if (i != largest) {
            swap (a, i, largest);
            heapify(a, largest);
        }
    }

    private static int right (int i) {
        return 2* i + 2;
    }

    private static int left (int i) {
        return 2 * i + 1;
    }

    private static void swap (int [] a, int i, int j) {
        int temp = a [i];
        a[i] = a[j];
        a[j] = temp;
    }
}

class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int [] arr;
        Random rand = new Random();
        arr = new int [50];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(22);
        }

        System.out.println(Arrays.toString(arr));
        HeapSort arrsort = new HeapSort();

        arrsort.sort(arr);
        System.out.println(Arrays.toString(arr));

        long endTime = System.nanoTime();
        System.out.println("На выполнение расчетов ушло " + (endTime - startTime) + " единиц времени");
    }
}
