package ru.breev.graph;

public class Vertex {

    private String label;

    protected boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
    }

    protected String getLabel() {
        return label;
    }

}
