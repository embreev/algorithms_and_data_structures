package ru.breev.graph;

import java.util.ArrayDeque;
import java.util.Queue;
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

    private int getUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && !vertexList[i].isWasVisited()) {
                return i;
            }
        }
        return -1;
    }

    private void resetToUnvisited() {
        for (int i = 0; i < MAX_VERTEX; i++) {
            vertexList[i].setWasVisited(false);
        }
    }

    protected void calcMinPath(int start, int end) {

        Queue<Integer> path = new ArrayDeque<>();

        vertexList[start].setWasVisited(true);
//        displayVertexById(start);
        path.add(start);

        int v;

        while (!path.isEmpty()) {
            v = getUnvisitedVertex(convertToInt(path.peek()));
            if (v == -1) {
                path.remove();
            }
            else {
                path.add(v);
//                displayVertexById(v);
                vertexList[v].setWasVisited(true);
                vertexList[v].setPreviousVertex(convertToInt(path.peek()));
                if (v == end) {
                    displayPath(v);
                    break;
                }
            }
        }
        resetToUnvisited();
    }

    private int convertToInt(Object peek) {
        if (peek == null) {
            return -1;
        }
        return (int) peek;
    }

    private void displayPath(int end) {
        Stack tmpStack = new Stack();
        int tmpId = end;
        while (vertexList[tmpId].getPreviousVertex() != -1) {
            tmpStack.push(vertexList[tmpId].getLabel());
            tmpId = vertexList[tmpId].getPreviousVertex();
        }
        tmpStack.push(vertexList[tmpId].getLabel());

        while (!tmpStack.empty()) {
            System.out.println(tmpStack.pop());
        }
    }
}
