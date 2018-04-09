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

public class MST {
    private static final int V = 5;
    int v;
    public int minKey(int key[], Boolean mstSet[])
    {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < V; v++);
        {
            if(mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v; 
            }
            return min_index;
        }
    }
    public void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge Weight: ");
        for( int i = 1; i < V; i++)
        {
            System.out.println(parent[i] + " - " + i + " " + 
                    graph[i][parent[i]]);
        }
    }
    
    public void primAlg(int graph[][])
    {
        int parent[] = new int[V];
        int key[] = new int [V];
        Boolean mstSet[] = new Boolean[V];
        //Initialize all keys and INF
        for(int i = 0; i < V; i++)
        {
            key[i] =Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        //Make the key = 0 so the verte is picked first
        key[0] = 0; 
        //First Node is always the root of the MST
        parent[0] = -1;
        //The MST will have V vertices
        for(int count = 0; count < V-1; count++)
        {
            int u = minKey(key, mstSet);
            //Add the seleted vertex tp the MST set
            mstSet[u] = true;
            for(int v = 0; v < V; v++)
            {
                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v])
                {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
    }
    
}
