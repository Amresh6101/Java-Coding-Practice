package org.epam.dsa.graph;

import java.util.*;

public class Graph {
    private int numberOfVertex;
    private List<List<Integer>> adjList;

    public Graph(int numberOfVertex){
        this.numberOfVertex=numberOfVertex;
        adjList=new ArrayList<>();
        for(int i=0;i<numberOfVertex;i++){
            adjList.add(new ArrayList<>());
        }
        //System.out.println(adjList);
    }
    // add edge
    public void addEdge(int from, int to){
        adjList.get(from).add(to);
        adjList.get(to).add(from);
    }
    // remove edge
    public void removeEdge(int from, int to){
        adjList.get(from).remove(to);
        adjList.get(to).remove(from);
    }

    // print graph
    public void  printGraph(){
        for (int i=0;i<numberOfVertex;i++){
            System.out.println("vertex:"+i+":");
            for (int neighbour: adjList.get(i)){
                System.out.println(" "+neighbour);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Graph graph=new Graph(7);

        graph.addEdge(0,6);
        graph.addEdge(5,6);
        graph.addEdge(0,4);
        graph.addEdge(4,1);
        graph.addEdge(4,2);
        graph.addEdge(1,3);
        graph.addEdge(5,3);

//        System.out.println("Adjacency list representation" +":");
//        graph.printGraph();

        // input me starting vertex dena hai.
        //graph.bfs(0);
        graph.dfs(0);

    }
    public void dfs(int startVertex){
        boolean[] visitedArray=new boolean[numberOfVertex];
        System.out.println("Staring vertex:"+ startVertex);
        dfsUtil(startVertex,visitedArray);
        System.out.println();
    }
    public void dfsUtil(int node,boolean[] visitedArray){
        visitedArray[node]=true;
        System.out.println("Node:"+ node);
        List<Integer> list=adjList.get(node);
        for(int v1: list){
            if(!visitedArray[v1]){
                dfsUtil(v1,visitedArray);
            }
        }
        System.out.println();
    }

    public  void bfs(int startVertex){
        boolean[] visitedArray=new boolean[numberOfVertex];
        Queue<Integer> queue=new ArrayDeque<>();

        visitedArray[startVertex]=true;
        queue.add(startVertex);

        System.out.println("Traversing through the graph:"+ startVertex);

        while(!queue.isEmpty()){

            int vertex=queue.poll();
            System.out.print(vertex + "--");

            List<Integer> list=adjList.get(vertex);
            for(int vtx: list){
                if(!visitedArray[vtx]){
                    visitedArray[vtx]=true;
                    queue.add(vtx);
                }
            }
            System.out.println();
        }
    }

}

