package ru.geek.homeworks;

import java.util.Arrays;
import java.util.Random;

public class JavaAlgorithm_5 {

    public static void main(String[] args) {
    
        //методы для рассчета времени выполнения расчетов 
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        System.out.println("На выполнение расчетов ушло " + (endTime - startTime) + " единиц времени");

        //запуск правильной рекурсии
        int n = 10;
        countdown(n);

        //рекурсивный бинарный поиск 
        int [] arr = new int []{5, 3, 4, 7, 9, 2, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(recBinaryFind (4, 0, arr.length-1, arr));

        //поиск методом слияния 
        int [] arr2 = new int [10];
        Random rand = new Random();

        for (int i = 0; i < arr2.length; i++){
            arr2 [i] = rand.nextInt(10);
        }

        System.out.println (Arrays.toString(sortMerge(arr2)));

    }

    //пример бесконечной рекурсии 
    public static int countdownEndless (int n) {
        System.out.println(n);
        return (countdown(n-1));
    }

    // рекурсия с условием выхода 
    public static int countdown (int n) {
        System.out.println(n);
        if (n == 0) {
            return n;
        }
        return (countdown(n-1));

    }

    //рекурсивный бинарный поиск 
    public static int recBinaryFind (int searchKey, int low, int high, int [] arr) {
        if (low > high)
            return arr.length;

        int mid = (low + high) /2;

        if (arr[mid] == searchKey)
            return mid;

        else if (arr[mid] < searchKey)
            return (recBinaryFind(searchKey, low +1, high, arr));
        else
            return (recBinaryFind(searchKey, low,high - 1, arr));
    }

    //метод слияния 
    private static int [] sortMerge (int [] arr) {
        int len = arr.length;
        if (len < 2 ) return arr;
        int middle = len /2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                    sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    public static int [] merge (int[] a, int[] b) {
        int [] result = new int [a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i ++) {
            result [i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }

}
