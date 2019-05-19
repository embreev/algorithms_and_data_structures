package ru.breev.graph;

import java.util.Stack;

public class Graph {

    private final int MAX_VERTEX = 10;

    private Vertex[] vertexList;

    private int[][] adjMat;

    private int size;

    private Stack stack;

    private Queue queue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTEX];
        adjMat = new int[MAX_VERTEX][MAX_VERTEX];
        size = 0;

        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    protected void addVertex(String label) {
        vertexList[size++] = new Vertex(label);
    }

    protected void addEdge(int first, int second) {
        adjMat[first][second] = 1;
        adjMat[second][first] = 1;
    }

    protected int getId(String label) {
        for (int i = 0; i < MAX_VERTEX; i++) {
            if (vertexList[i].getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    protected void displayAllVertex() {
        for (int i = 0; i < MAX_VERTEX; i++) {
            displayVertexById(i);
        }
    }

    private void displayVertexById(int i) {
        System.out.println(vertexList[i].getLabel());
    }

    private int getUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }

        return -1;
    }

    public void dfs() {
        stack = new Stack();
        vertexList[0].wasVisited = true;
        displayVertexById(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex((Integer) stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertexById(v);
                stack.push(v);
            }
        }
        resetToUnvisited();
    }

    public void bfs() {
        queue = new Queue(MAX_VERTEX);

        vertexList[0].wasVisited = true;

        displayVertexById(0);

        queue.insert(0); // Вставка в конец очереди
        int v2;
        while (!queue.isEmpty()) {
            int v1 = (int) queue.remove();
            while ((v2 = getUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true; // Пометка
                displayVertexById(v2); // Вывод
                queue.insert(v2);
            }
        }
    }

    private void resetToUnvisited () {
        for (int i = 0; i < MAX_VERTEX; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    class Queue<E> {

        protected E[] data;
        protected int queueSize;

        protected int start;
        protected int end;

        public Queue(int queueSize) {
            this.data = (E[]) new Object[queueSize];
            start = 0;
            end = -1;
        }

        public void insert(E element) {
            if (!full()) {
                if (end == data.length - 1) {
                    end = -1;
                }
                data[++end] = element;
                queueSize++;
            }
        }

        public E remove() {
            if (!isEmpty()) {
                if (start == data.length) {
                    start = 0;
                }
            }
            queueSize--;
            return data[start++];
        }

        public E peek() {
            return (!isEmpty()) ? data[end] : null;
        }

        public boolean isEmpty() {
            return queueSize == 0;
        }

        public boolean full() {
            return data.length == queueSize;
        }

        public int size() {
            return data.length;
        }
    }
}
