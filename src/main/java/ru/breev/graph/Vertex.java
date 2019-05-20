package ru.breev.graph;

public class Vertex {

    private String label;

    private boolean wasVisited;

    private int previousVertex;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
        this.previousVertex = -1;
    }

    protected String getLabel() {
        return label;
    }

    protected int getPreviousVertex() {
        return previousVertex;
    }

    protected void setPreviousVertex(int previousVertex) {
        this.previousVertex = previousVertex;
    }

    protected void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    protected boolean isWasVisited() {
        return wasVisited;
    }

}
