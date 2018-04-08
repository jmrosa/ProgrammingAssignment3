/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg232assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jessicarosa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String fileName = "input.txt";
        String file = null;
        
        FileReader in = null;
        FileReader out = null;
        
        try {
            in = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(in);
                    int n = 5; //size of the array
                    int[][] adjMat = new int[n][n];
                    int i = 0;

                while((file = bufferedReader.readLine()) != null){
                        String[] ele = file.split(",");
                        //System.out.println("last line");
                        for(int j = 0; j < ele.length; j++) {
                            adjMat[i][j] = Integer.parseInt(ele[j]);
//                            if(adjMat[i][j] != 100) {
//                                Edge e = new Edge(i, j, adjMat[i][j]);
//                            }
                            System.out.print(adjMat[i][j] + " ");
                        }
                        Node c = new Node(i);
                        i++;
                        System.out.println();
                        System.out.println(c.vertex);
        }
                
            bufferedReader.close();
            }    
            catch(FileNotFoundException FNF){
            System.out.println("Unable to open file '" + fileName + "'");
            }
            catch(IOException IOE){
            System.out.println("Error reading file '" + fileName + "'");
            }

        
    }
    
}
