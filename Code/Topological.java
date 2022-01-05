import java.util.*;
import java.io.*;

public class Topological {

	private DiGraphADT g;
	private int n;

	public Topological() {

		n = 10;
		g = new DiGraphEdgeList(n);
		try {
			readGraph();
		} catch (Exception e) {
			System.out.println("Invalid file content");
		}
	}

	private void readGraph() throws Exception {
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
			g.addEdge(firstNode, secNode);

			st.nextToken();
		}
	}

	public void topologicalOrder() {

		Queue<Integer> order = new LinkedList<Integer>();
		int a = 0;

		Queue<Integer> temp = new LinkedList<Integer>();

		ArrayList<Integer> inDegree = new ArrayList<Integer>();
		for (int i = 0; i < g.nNodes(); i++) {
			inDegree.add(g.inDegree(i));
		}

		for (int i = 0; i < g.nNodes(); i++) {
			if (inDegree.get(i) == 0) {
				temp.add(i);
			}
		}

		while (!temp.isEmpty()) {
			a = temp.remove();

			order.add(a);

			for (int i = 0; i < g.successors(a).size(); i++) {
				inDegree.set(g.successors(a).get(i), inDegree.get(g.successors(a).get(i)) - 1);

			}
			for (int i = 0; i < inDegree.size(); i++) {
				if (inDegree.get(i) == 0 && !order.contains(i) && !temp.contains(i)) {
					temp.add(i);
				}
			}

		}
		System.out.println(order);
	}

	public static void main(String[] args) {
		Topological gr = new Topological();
		gr.topologicalOrder();
	}
}
