import java.util.*;
import java.io.*;

/**
 * Class Topological 
 * The main method creates and populates a graph from edges in file
 * Edges.txt. It then calls method topologicalOrder() which you are asked to
 * code using the final algorithm for this presented in lectures (slide 13 
 * of MyPlace item 10.5.)
 * 
 * @author I.Ross 
 */
public class Topological
{
    // instance variables - do not alter
    private DiGraphADT g;
    private int n;
    
    /**
     * Constructor for objects of class Topological - do not alter except
     * that you may wish to replace the instance of DiGraphEdgeList with an 
     * instance of a different implementation of DiGraphADT
     */
    public Topological()
    {
        // initialise instance variables
        n = 10;   // example graph used here has 10 nodes
        g = new DiGraphEdgeList(n);
        try {
            readGraph();
        }
        catch (Exception e){
            System.out.println("Invalid file content");
        }
    }

    /**
    * populates the graph taking data from file Edges.txt - do not alter
    */
    private void readGraph() throws Exception 
    {
        int firstNode, secNode;
        Reader r = new BufferedReader(new FileReader("Edges.txt"));
        StreamTokenizer st = new StreamTokenizer(r);
        st.parseNumbers();
        st.nextToken();
        while (st.ttype != StreamTokenizer.TT_EOF) {
          firstNode = (int) st.nval;
          st.nextToken();
          secNode = (int) st.nval;
          System.out.println(firstNode + " " + secNode);
          g.addEdge(firstNode,secNode);
          st.nextToken();
        }
    }

   /** prints a topological ordering of the nodes in the graph, using 
    * the improved algorithm presented in lectures. This algorithm makes use
    * of a queue holding nodes of degree 0
   */
    public void topologicalOrder()
    {
        // declare local variables
        
        
        // create an empty queue
 
        
        // populate an array with initially holding the indegrees of nodes
        // and place nodes with indegree 0 on the queue
 
        
        // repeatedly remove a node from the queue, print it (i.e. display 
        // the node number), decrement the array entry for all its successor 
        // nodes and add to the queue any nodes whose indegree hence falls to 0

        
    }
    
    /** creates and populates a graph and then prints a topological
     * ordering of the nodes  - do not alter
     */    
    public static void main(String[] args)
    {
        Topological gr = new Topological();
        gr.topologicalOrder();
    }
}

