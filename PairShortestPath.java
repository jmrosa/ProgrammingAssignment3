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

public class PairShortestPath{
    final static int INF = 99999;
    final static int V = 5;
    public void floydeWarshall(int graph[][])
    {
        int dist [][] = new int[V][V];
        for(int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                dist[i][j] = graph[i][j];
            }
        }
    for(int k = 0; k < V; k++)
    {
        for(int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                if (dist[i][k] + dist [k][j] < dist[i][j])
                {
                    dist[i][j] = dist[i][k] + dist [k][j];
                }
            }
        }
    }
 printSolution(dist);
}
            
public void printSolution(int dist[][])
{
    System.out.println("Shortest Distances between every pair of vertices:");
    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < V; j++)
        {
            if (dist[i][j] == INF)
            {
                System.out.println("INF");
            }
            else 
            {
                System.out.println(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
}
