/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232assignment3;

/**
 *
 * @author jessicarosa
 */
public class Edge {
    public Node n1;
    public Node n2;
    public int weight;
    
    public Edge(Node n1, Node n2, int weight) {
        this.n1 = n1;
        this.n2 = n2;
        this.weight = weight;
    }
}
