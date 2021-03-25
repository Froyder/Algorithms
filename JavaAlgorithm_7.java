package javaAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

class JavaAlgorithm_ {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');

        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE
        graph.addEdge(0, 5); //AH

       graph.displayVertex(4);

       long startTime = System.nanoTime();
       // обычный обход в глубину
       graph.dfs();
       //рекурсивный обход в глубину
       graph.DFS(0);
       long endTime = System.nanoTime();
       System.out.println("На выполнение расчетов ушло " + (endTime - startTime) + " единиц времени");

       startTime = System.nanoTime();
       //обычный метод для обхода в ширину
       graph.bfs();
       //альтернативный метод для обхода в глубину
       graph.bfs2(0);
       endTime = System.nanoTime();
       System.out.println("На выполнение расчетов ушло " + (endTime - startTime) + " единиц времени");

    }
}

    class myStack {
    private int maxSize;
    private int [] stackArr;
    private int top;

        public myStack (int size) {
            this.maxSize = size;
            this.stackArr = new int[size];
            this.top = -1;
        }

        public void push (int i) {
            stackArr[++top] = i;
        }

        public int pop() {
            return stackArr[top--];
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public int peek() {
            return stackArr[top];
        }

    }

    class Vertex{

        public char label;

        public boolean wasVisited;

        public Vertex (char label) {
            this.label = label;
            this.wasVisited = false;
        }
    }

    class Graph {
        private final int MAX_VERTS = 32;
        private Vertex[] vertexList;
        private int[][] adjMat;
        private int size;
        private myStack stack;

        public Graph() {
            stack = new myStack(MAX_VERTS);
            vertexList = new Vertex[MAX_VERTS];
            adjMat = new int[MAX_VERTS][MAX_VERTS];
            size = 0;
            for (int i = 0; i < MAX_VERTS; i++) {
                for (int j = 0; j < MAX_VERTS; j++)
                    adjMat[i][j] = 0;
            }
        }

        private int getAdjUnvisitedVertex (int ver) {
            for (int i = 0; i < size; i++) {
                if (adjMat [ver][i] == 1 && vertexList[i].wasVisited == false) {
                    return i;
                }
            }
            return -1;
        }

        // обычный обход в глубину
        public void dfs () {
            vertexList[0].wasVisited = true;
            displayVertex(0);
            stack.push(0);
            while (!stack.isEmpty()) {
                int v = getAdjUnvisitedVertex(stack.peek());
                if (v == -1) {
                    stack.pop();
                } else {
                    vertexList[v].wasVisited = true;
                    displayVertex(v);
                    stack.push(v);
                }
            }
           for (int i = 0; i < size; i++) {
               vertexList[i].wasVisited = false;
           }
        }

        // рекурсивный обход в глубину
        public void DFS (int f) {
            vertexList[f].wasVisited = true;

            for (int i = 0; i < size; i++) {
                int v = getAdjUnvisitedVertex(f);
                if (!vertexList[i].wasVisited && v!=-1 && i==v) {
                    fullDisplayVertex(f,v);
                    DFS(i);
                }
            }
        }

        //обычный метод для обхода в ширину
        public void bfs () {
            Queue<Integer> queue = new LinkedList<>();
            vertexList[0].wasVisited = true;
            displayVertex(0);
            queue.add(0);
            int v2;
            while (!queue.isEmpty()){
                int v1 = queue.remove();
                while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                    vertexList[v2].wasVisited = true;
                    displayVertex(v2);
                    queue.add(v2);
                }
            }
            for (int i = 0; i < size; i++) {
                vertexList[i].wasVisited = false;
            }
        }

        //альтернативный метод для обхода в ширину
        public void bfs2 (int v) {
            int[] queue = new int [size];
            int qH = 0;
            int qT = 0;

            vertexList[0].wasVisited = true;
            queue[qT++] = v;

            displayVertex(0);

            int v2;
            while (qH < qT) {
                v = queue[qH++];

                for (int i = 0; i < size; i++) {
                    v2 = getAdjUnvisitedVertex(v);
                    if (!vertexList[i].wasVisited && v2 != -1) {
                        vertexList[i].wasVisited = true;
                        displayVertex(qT);
                        queue[qT++] = i;
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                vertexList[i].wasVisited = false;
            }
        }


        public void addVertex (char label) {
            vertexList [size++] = new Vertex(label);
        }

        public void addEdge (int start, int end) {
            adjMat [start] [end] = 1;
            adjMat [end] [start] = 1;
        }

        public void fullDisplayVertex (int vertex1, int vertex2) {
            System.out.println("Вершины " + vertexList[vertex1].label + "" + vertexList[vertex2].label);
        }

        public void displayVertex (int vertex) {
            System.out.println(vertexList[vertex].label);
        }

    }

