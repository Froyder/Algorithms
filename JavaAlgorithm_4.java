package ru.geek.homeworks;

import java.util.*;

public class JavaAlgorithm_4 {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        //стэковый блок
        Stack<ArrayObject> stackObject = new Stack<>();
        startTime = System.nanoTime();

        stackObject.push(new ArrayObject(4,5));
        stackObject.push(new ArrayObject(5,5));
        stackObject.push(new ArrayObject(1,8));
        stackObject.push(new ArrayObject(3,1));

        stackObject.peek().print();
        stackObject.pop().print();

        while (!stackObject.empty()) {
            stackObject.pop().print();
        }

        System.out.println(stackObject.empty());

        StackM stack = new StackM(5);
        Random random = new Random();

        while (!stack.isFull()) {
            stack.push(random.nextInt(10));
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println();
        endTime = System.nanoTime();
        System.out.println("На выполнение задания 4.1 ушло " + (endTime - startTime) + " единиц времени");

        //очередь
        startTime = System.nanoTime();
        Queue<ArrayObject> queue = new LinkedList<>();
        queue.add(new ArrayObject(5,1));
        queue.add(new ArrayObject(1,1));
        queue.add(new ArrayObject(3,2));

        while (!queue.isEmpty()) {
            queue.poll().print();
        }
        System.out.println();

        // своя очередь
        QueueM q = new QueueM (5);
        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(40);
        q.insert(50);
        q.remove();
        q.remove();

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        System.out.println();
        endTime = System.nanoTime();
        System.out.println("На выполнение задания 4.2 ушло " + (endTime - startTime) + " единиц времени");

        //обычная очередь дек
        startTime = System.nanoTime();
        Deque<ArrayObject> quObj = new ArrayDeque<>();
        quObj.add(new ArrayObject(5,1));
        quObj.add(new ArrayObject(1,1));
        quObj.add(new ArrayObject(3,2));

        quObj.addFirst(new ArrayObject(2, 1));
        quObj.addLast(new ArrayObject(2, 1));

        while (!quObj.isEmpty()) {
            quObj.poll().print();
        }

        quObj.addFirst(new ArrayObject(3, 2));
        quObj.addFirst(new ArrayObject(6, 7));
        quObj.addLast(new ArrayObject(4, 5));

        System.out.println("Poll and peek");
        quObj.pollFirst().print();
        quObj.pollLast().print();
        quObj.peekFirst().print();
        quObj.peekLast().print();
        endTime = System.nanoTime();
        System.out.println("На выполнение задания 4.3 ушло " + (endTime - startTime) + " единиц времени");

        //приорететная очередь декью
        startTime = System.nanoTime();
        System.out.println("Prior");
        PriorityQueue<Integer> prior = new PriorityQueue<>();
        Random rand = new Random();
        prior.add(9);
        prior.add(3);
        prior.add(7);
        prior.offer(5);

        while (!prior.isEmpty()) {
            System.out.println(prior.poll());
        }
        endTime = System.nanoTime();
        System.out.println("На выполнение задания 4.4 ушло " + (endTime - startTime) + " единиц времени");

        //стек
        startTime = System.nanoTime();
        Link.StackList s1 = new Link.StackList();
        s1.push("Jhon", 30);
        s1.push("Mike", 20);
        s1.push("Tom", 40);
        s1.display();
        while (!s1.isEmpty()){
            System.out.println("Элемент " + s1.pop() + " удален и стека");
        }

        //очередь на основе связанного спика
        Link.QueueTest queueTest = new Link.QueueTest();
        queueTest.insert("Jhon",10);
        queueTest.insert("Mike",20);
        queueTest.insert("Tom",30);
        queueTest.display();

        endTime = System.nanoTime();
        System.out.println("На выполнение задания 4.5 ушло " + (endTime - startTime) + " единиц времени");
    }


static class ArrayObject {
    private int x;
    private int y;

    public ArrayObject (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print () {
        System.out.println("X: " + x + ", " + "Y: " + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

    static class StackM {
        private int maxSize;
        private int [] stack;
        private int top;

        public StackM (int size) {
        this.maxSize = size;
        this.stack = new int[this.maxSize];
        this.top = -1;
        }

        public void push (int i) {
            this.stack[++this.top] = i;
        }

        public int pop () {
            return this.stack[this.top--];
        }

        public int peek () {
            return this.stack[this.top];
        }

        public boolean isEmpty () {
            return (this.top == -1);
        }

        public boolean isFull () {
            return (this.top == this.maxSize-1);
        }

    }

    static class QueueM {
        private int maxSize;
        private int [] queue;
        private int front;
        private int rear;
        private int items;

        public QueueM (int s) {
            maxSize = s;
            queue = new int[maxSize];
            front = 0;
            rear = -1;
            items = 0;
        }

        public void insert (int i) {
            if (rear == maxSize - 1)
                rear = -1;
                queue[++rear] = i;
                items++;
        }

        public int remove () {
            int temp = queue [front++];
            if (front == maxSize)
                front = 0;
            items--;
            return temp;
        }

        public int peek () {
            return queue[front];
        }

        public boolean isEmpty () {
            return (items == 0);
        }

        public boolean isFull () {
            return (items == maxSize);
        }

        public int size () {
            return items;
        }

    }

    static class Link {
        public String name;
        public int age;

        public Link next;

        public Link(String name, int age){
            this.name = name;
            this.age = age;
        }

        public void display () {
            System.out.println(("Name " + this.name + ", age " + this.age));
        }

        static class LinkedList {
            public Link first;

            public LinkedList () {
                first = null;
            }

            public boolean isEmpty() {
                return (first == null);
            }

            public void insert (String name, int age){
                Link newLink = new Link(name, age);
                newLink.next = first;
                first = newLink;
            }

            public  Link delete () {
                Link temp = first;
                first = first.next;
                return temp;
            }

            public void display() {
                Link current = first;
                while (current != null) {
                    current.display();
                    current = current.next;
                }
            }
        }

        static class StackList {
            private LinkedList list;

            public StackList () {
                list = new LinkedList();
            }

            public void push (String name, int age) {
                list.insert (name, age);
            }

            public String pop () {
                return list.delete().name;
            }

            public boolean isEmpty () {
                return list.isEmpty();
            }

            public void display () {
                list.display();
            }
        }

        static class QueueTest {
            private LinkedList queue;

            public QueueTest () {
                queue = new LinkedList();
            }

            public void insert (String name, int age){
                queue.insert(name, age);
            }

            public Link delete () {
                return queue.delete();
            }

            public boolean isEmpty () {
                return queue.isEmpty();
            }

            public void display () {
                queue.display();
            }
        }

    }

}
