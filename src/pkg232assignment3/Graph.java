/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author bradl
 */

import java.util.*;
import java.lang.*;
import java.io.*;
public class Graph {
  int dist[][];
    
 
    //Kruskals
    class Edge implements Comparable <Edge> 
    {
        int src;
        int dest;
        int weight;
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    }
    class subset
    {
        int parent; 
        int rank; 
    }
   
    int V;
    int E;
    Edge edge[];
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++)
        {
            edge[i] = new Edge();
        }
    }
    
    public int find(subset subsets[], int i)
    {
        if(subsets[i].parent != i)
        {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    
    public void Union(subset subsets[], int x, int y)
    { 
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if(subsets[xroot].rank < subsets[yroot].rank)
        {
            subsets[xroot].parent = yroot;
        }
        else if (subsets[xroot].rank > subsets[yroot].rank)
        {
            subsets[yroot].parent = xroot;
            }
        else{
        subsets[yroot].parent = xroot;
        subsets[xroot].rank ++;
        }
    }
    
public void KruskalMST()
{
    Edge result [] = new Edge[V];
    int e =0;
    for(int i = 0; i < V; i++)
    {
        result[i] = new Edge();
        Arrays.sort(edge);
        subset subsets[] = new subset[V];
        for(i = 0; i < V; i++)
        {
            subsets[i] = new subset();
            for(int v = 0; v < V; ++v)
            {
                subsets[v].parent = v;
                subsets[v].rank = 0; 
        }
        //Index used to picl to next edge 
        i =0; 
        //The number of edges to be taken in equal to e < V-1 
        while(e < (V-1))
        {
            Edge next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if(x != y)
            {
                result[e++] = next_edge;
                Union(subsets,x,y);
            }
            for (i =0; i < e; ++i)
            {
                System.out.println(result[i].src + "--"+result[i].dest+"=="+ result[i].weight);
            }
        }
        }
    }
}
}



    
