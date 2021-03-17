package ru.geek.homeworks;

import java.util.Arrays;
import java.util.Random;

public class JavaAlgorithm_2 {

    public static void main(String[] args) {

        // Задание 2.1
        int[] array = new int[15];
        int[] arrayCopy;

        Random random = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            array [i] = random.nextInt(10);
        }

        long startTime =  System.nanoTime();
        arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(array) + ", \n" + Arrays.toString(arrayCopy) + ", \n" + array.equals(arrayCopy) +
                            "," + Arrays.equals(array,arrayCopy));
        long endTime = System.nanoTime();
        System.out.println("На вычисление в задании 2.1 ушло " + (endTime - startTime) + " единиц времени\n");

        // Задание 2.2
        int x = random.nextInt(10);
        startTime =  System.nanoTime();
        System.out.println("Значение " + x + " находится в ячейке "  + (lineSearch(array, x)) +".");
        endTime = System.nanoTime();
        System.out.println("На вычисление линейным поиском в задании 2.2 ушло " + (endTime - startTime) + " единиц времени\n");

        x = random.nextInt(10);
        startTime =  System.nanoTime();
        System.out.println("Значение " + x + " находится в ячейке "  + binarySearch(array, x) + ".");
        endTime = System.nanoTime();
        System.out.println("На вычисление бинарным поиском в задании 2.2 ушло " + (endTime - startTime) + " единиц времени\n");

        // Задание 2.3
        int [] array400 = new int [400];
        for (int i = 0; i < array400.length - 1; i++) {
            array400 [i] = random.nextInt(99);
        }
        int [] array400copy = Arrays.copyOf(array400, array400.length);

        startTime =  System.nanoTime();
        Arrays.sort(array400copy);
        endTime = System.nanoTime();
        System.out.println("На сортировку массива длиной 400 элементов ушло " + (endTime - startTime) + " единиц времени\n");

        // Задание 2.4 - сортировка пузырьком
        int [] array400_Bubble = Arrays.copyOf(array400, array400.length);
        int temp;
        boolean sorted;

        startTime =  System.nanoTime();
        sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array400_Bubble.length - 1; i++) {
                if (array400_Bubble[i] > array400_Bubble [i+1]) {
                        sorted = false;
                        temp = array400_Bubble[i];
                        array400_Bubble [i] = array400_Bubble [i+1];
                        array400_Bubble [i+1] = temp;
                }
            }
        }   endTime = System.nanoTime();
        System.out.println("На сортировку массива (400) 'пузырьком' ушло " + (endTime - startTime) + " единиц времени\n");

        // Задание 2.5 - сортировка методом выбора
        int [] array400_Selection = Arrays.copyOf(array400, array400.length);
        int tempSelection;

        startTime =  System.nanoTime();
        for (int i = 0; i < array400_Selection.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array400_Selection.length; j++) {
                if (array400_Selection[j] < array400_Selection [min]) {
                    min = j;
                }
            }
            swapSelection (array400_Selection, i, min);
        }
        endTime = System.nanoTime();
        System.out.println("На сортировку массива (400) методом выбора ушло " + (endTime - startTime) + " единиц времени\n");

        //задание 2.6 - сортировка методов вставки
        int [] array400_Insert = Arrays.copyOf(array400, array400.length);
        int tempInsert;
        int in;

        startTime =  System.nanoTime();
        for (int i = 1; i < array400_Insert.length; i++) {
            tempInsert = array400_Insert [i];
            in = i;
            while (in > 0 && array400_Insert [in-1] >= tempInsert) {
                array400_Insert [in] = array400_Insert [in-1];
                in--;
            }
            array400_Insert [in] = tempInsert;
        }
        endTime = System.nanoTime();
        System.out.println("На сортировку массива (400) методом вставки ушло " + (endTime - startTime) + " единиц времени\n");

    }


    //метод для линейного поиска
    public static int lineSearch (int [] array, int element) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == element) {
                return i;
            }
        } return -1;
    }

    // метод для бинарного поиска
    public static int binarySearch (int [] array, int element) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex)/2;

            if (array[middleIndex] == element) {
                return middleIndex;
            } else if (array [middleIndex] < element) {
                firstIndex = middleIndex + 1;
            } else if (array [middleIndex] > element) {
                lastIndex = middleIndex - 1;
            }
        } return -1;
    }

    //метод для сортировки методом выбора (2.5)
    public static void swapSelection (int [] array, int first, int second){
        int temp = array[first];
        array [first] = array [second];
        array [second] = temp;
    }

    //класс и методы для сортировки пузырьком (2.4)
    static class Bubble {
        private long [] array;
        private int elements;

        public Bubble (int max) {
            array = new long[max];
            elements = 0;
        }

        public void into (long value) {
            array[elements] = value;
            elements++;
        }

        public void printer () {
            for (int i = 0; i < elements; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println("Вывод массива закончен");
        }

        public void swapElements (int first, int next) {
            long temp = array[first];
            array[first] = array [next];
            array [next] = temp;
        }

        public void bubbleSort() {
            for (int i = elements - 1; i >=1; i--) {
                for (int j = 0; j < i; j++ ) {
                    if (array[j] > array [i]) {
                        swapElements(j, j + 1);
                    }
                }
            }
        }

    }

}


/*
Задание 2.1
На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
Выполните обращение к массиву и базовые операции класса Arrays.
Оценить выполненные методы с помощью базового класса System.nanoTime().
Задание 2.2
На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.

Задание 2.3
Создайте массив размером 400 элементов.
Выполните сортировку с помощью метода sort().
Оцените сортировку с помощью базового класса System.nanoTime().

Задание 2.4
На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
Оцените сортировку с помощью базового класса System.nanoTime().
Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.

Задание 2.5
На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
Оцените сортировку с помощью базового класса System.nanoTime().
Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.

Задание 2.6
На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
Оцените сортировку с помощью базового класса System.nanoTime().
Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
 */