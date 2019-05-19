package ru.breev.graph;

public class App {

    public static void main(String[] args) {
        Graph city = new Graph();
        city.addVertex("Москва");
        city.addVertex("Тула");
        city.addVertex("Рязань");
        city.addVertex("Калуга");
        city.addVertex("Липецк");
        city.addVertex("Тамбов");
        city.addVertex("Орел");
        city.addVertex("Саратов");
        city.addVertex("Курск");
        city.addVertex("Воронеж");

        city.addEdge(city.getId("Москва"), city.getId("Тула"));
        city.addEdge(city.getId("Москва"), city.getId("Рязань"));
        city.addEdge(city.getId("Москва"), city.getId("Калуга"));
        city.addEdge(city.getId("Тула"), city.getId("Липецк"));
        city.addEdge(city.getId("Рязань"), city.getId("Тамбов"));
        city.addEdge(city.getId("Калуга"), city.getId("Орел"));
        city.addEdge(city.getId("Липецк"), city.getId("Воронеж"));
        city.addEdge(city.getId("Тамбов"), city.getId("Саратов"));
        city.addEdge(city.getId("Орел"), city.getId("Курск"));
        city.addEdge(city.getId("Саратов"), city.getId("Воронеж"));
        city.addEdge(city.getId("Курск"), city.getId("Воронеж"));

//        city.displayAllVertex();

//        city.dfs();
//        System.out.println("==========");
//        city.bfs();

        city.calcMinPath(city.getId("Тамбов"), city.getId("Воронеж"));
    }
}
