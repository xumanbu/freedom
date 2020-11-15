package com.feiwang.freedom.graph;

public class GraphByTwoArray {

    private int[][] nodeEdge;

    public GraphByTwoArray(int nodeSize){
        nodeEdge = new int[nodeSize][nodeSize];
    }

    public void addEdge(int s, int t){
        nodeEdge[s][t] = 1;

    }

}
