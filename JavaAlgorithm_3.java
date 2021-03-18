package ru.geek.homeworks;

import java.util.*;

public class JavaAlgorithm_3 {

    public static void main(String[] args) {

        Integer[] array = new Integer[15];
        Random rand = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            array [i] = rand.nextInt(10);
        }

        //3.1 - На основе массива реализуйте простой список и коллекцию. Оцените время выполнения преобразования.
        long startTime =  System.nanoTime();
        List<Integer> arrayList = Arrays.asList(array);
        ArrayList <Integer> arrayListCopy = new ArrayList<>(arrayList);
        long endTime = System.nanoTime();
        System.out.println("На выполнение задания 3.1 ушло " + (endTime - startTime) + " единиц времени");

        //3.2 - ArrayList (реализуйте основные методы добавления, удаления и получения объекта или элемента из списка)
        startTime =  System.nanoTime();
        arrayListCopy.add(1);
        arrayListCopy.add(2);
        arrayListCopy.add(2);
        System.out.println(arrayListCopy);

        arrayListCopy.add(1,4);
        arrayListCopy.set(2, 13);

        System.out.println(arrayListCopy);
        System.out.println(arrayListCopy.get(2));

        arrayListCopy.remove(1);
        arrayListCopy.remove(13);
        System.out.println(arrayListCopy);

        ArrayList<ArrayObject> myArrayList = new ArrayList<>();
        myArrayList.add(new ArrayObject(1,2));
        myArrayList.add(new ArrayObject(3,2));
        myArrayList.add(new ArrayObject(5,8));

        myArrayList.set(2, new ArrayObject(1,2));
        myArrayList.get(0);
        for (ArrayObject number : myArrayList) {
            number.printArray();
        }
        endTime = System.nanoTime();
        System.out.println("На выполнение задания 3.2 ушло " + (endTime - startTime) + " единиц времени");

        //3.3 - простой односвязный список и его базовые методы.
        MyLinkedList<String> list = new MyLinkedList<>();

        list.insert("Jhon");
        list.insert("Paul");
        list.insert("George");
        list.display();

        System.out.println("\n" + list.find("Paul"));
        System.out.println();

        //3.4 - реализуйте простой двусторонний список и его базовые методы
        LinkedList<String> newList = new LinkedList<>();
        ArrayList<String> newListCopy = new ArrayList<>(newList);

        newList.add("One");
        newList.add("Two");
        newList.add("Three");

        System.out.println(newList);

        newList.add(1, "Four");
        newList.set(2,"Set");
        System.out.println(newList);
        System.out.println(newList.get(2));

        newList.remove(1);
        newList.remove("Set");

        newList.addFirst("First");
        newList.addLast("Last");
        System.out.println(newList);
        System.out.println(newList.peekFirst());
        System.out.println(newList.peekLast());
        System.out.println(newList.pollFirst());
        System.out.println(newList.pollLast());
        System.out.println(newList);

        if (newList.contains("One")) {
            System.out.println("Список содержит One\n");
        };

        LinkedList<ArrayObject> newLinkedList = new LinkedList<>();
        newLinkedList.add(new ArrayObject(1,2));
        newLinkedList.add(new ArrayObject(3,2));
        newLinkedList.add(new ArrayObject(5,8));

        newLinkedList.set(2, new ArrayObject(1,2));

        for (ArrayObject number : newLinkedList) {
            number.printArray();
            System.out.println(number.getX() + " " + number.getY());
        }
        System.out.println();

        //3.5 - Итераторы и базовые операции с ними
        startTime =  System.nanoTime();
        LinkedList<String> lastList = new LinkedList<>();
        ArrayList<String> lastListCopy = new ArrayList<>();

        lastList.add("One");
        lastList.add("Two");
        lastList.add("Three");
        lastListCopy.addAll(lastList);
        System.out.println(lastList.equals(lastListCopy));
        System.out.println(lastList.hashCode());
        System.out.println(lastList + "\n");

        Iterator<String> iterator = lastList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + ", ");
            iterator.remove();
        }
        System.out.println("Test" + lastList + "\n");

        LinkedList<ArrayObject> lastLinkedList = new LinkedList<>();
        lastLinkedList.add(new ArrayObject(1,2));
        lastLinkedList.add(new ArrayObject(3,2));
        lastLinkedList.add(new ArrayObject(5,8));
        lastLinkedList.set(2, new ArrayObject(1,2));

        ListIterator<ArrayObject> iteratorAO = lastLinkedList.listIterator();
        while (iteratorAO.hasNext()) {
            iteratorAO.next();
        }

        Random random = new Random();

        ArrayObject aO;
        while (iteratorAO.hasPrevious()){
            aO = iteratorAO.previous();
            aO.printArray();
            iteratorAO.set(new ArrayObject(random.nextInt(10), random.nextInt(10) ));
        }
        System.out.println("");

        for (ArrayObject number : lastLinkedList) {
            number.printArray();
            System.out.println(number.getX() + " " + number.getY());
        }
        endTime = System.nanoTime();
        System.out.println("На выполнение задания 3.5 ушло " + (endTime - startTime) + " единиц времени");


    }

    static class ArrayObject {
        private int x;
        private int y;

        public ArrayObject (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void printArray () {
            System.out.println("X: " + x + ", " + "Y: " + y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    //класс для односвязного списка
    static class Link<T> {
        private T link;
        private Link<T> next;

        public Link (T link) {
            this.link = link;
        }

        public Link <T> getNext(){
            return next;
        }

        public void setNext (Link<T> next) {
            this.next = next;
        }

        public T getValue() {
            return link;
        }
     }

    //класс для односвязного списка
    static class MyLinkedList<T> {
        private Link <T> first;

        public MyLinkedList() {
            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert (T link){
            Link <T> l = new Link<>(link);
            l.setNext(first);
            this.first = l;
        }

        public Link <T> delete () {
            Link <T> temp = first;
            first = first.getNext();
            return temp;
        }

        public void display() {
            Link <T> current = first;
            while (current != null) {
                System.out.println(current.getValue());
                current=current.getNext();
            }
        }

        public T find (T searchNode) {
            Link <T> findNode = new Link <> (searchNode);
            Link <T> current = first;
            while (current != null) {
                if (current.getValue().equals(findNode.getValue())){
                    return findNode.getValue();
                }
                current = current.getNext();
            }
            return null;
        }




    }

}
