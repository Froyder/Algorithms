package ru.geek.homeworks;

public class TestingGround {

        public static class Example {
        }

    public static void main(String[] args) {

        //заводим переменные трех типов данных: примитив, ссылочный, свой класс
        int x = 13;
        String word = "word";
        Example example = new Example();

        //выводим их в консоль
        System.out.println(x + ", " + "word" + ", " + example.getClass().getSimpleName());

        //создаем переменные для сравнения, выводим результаты сравниний в консоль
        int x1 = 13;
        String word1 = "word";
        Example example1 = new Example();

        System.out.println(x == x1);
        System.out.println(word.equals(word1));
        System.out.println(example.equals(example1));

        //запускаем отсчет времени, вычисляем значение x перебором
        System.nanoTime();

        for (int i = 0; i < 20; i++) {
            if (i == x) {
                System.out.println("Значение x = " + i + ", мы узнали это методом перебора");
            }
        }
        System.out.println("На вычисление ушло " + System.nanoTime() + " единиц времени");

    }
}