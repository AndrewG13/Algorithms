import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Problem14 {

	private int[][] edges; // adjacency matrix
	private Object[] labels;

	public Problem14(int n) {
		// n: size of nodes
		// weighted graph
		edges = new int[n][n];
		// edges[i][j] saves the weight of edge i->j, assume weight > 0
		// for unweighted graph
		// set edges[i][j] to 1 if there exists an edge i->j
		// set edges[i][j] to 0 otherwise
		labels = new Object[n];
	}

	public void setLabel(int vertex, Object label) {
		// vertex: vertex index, label: vertex name
		labels[vertex] = label;

	}

	public Object getLabel(int vertex) {
		return labels[vertex];
	}

	public int size() {
		return edges.length;
	}

	public void addEdge(int source, int target, int w) {
		// w for weight
		edges[source][target] = w;
		edges[target][source] = w;// undirected graph
	}

	public boolean isEdge(int source, int target) {
		// if edges[i][j] > 0, there exists an edge from vertex i to vertex j
		return edges[source][target] > 0;
	}

	public void removeEdge(int source, int target) {
		edges[source][target] = 0;
		edges[target][source] = 0;// undirected graph
	}

	public int getWeight(int source, int target) {
		return edges[source][target];
	}

	public int[] neighbors(int vertex) {
		// find neighbors of a given vertex
		int count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				count++;
		}
		final int[] answer = new int[count];
		count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				answer[count++] = i;
		}
		return answer;
	}

	public void print() {
		for (int j = 0; j < edges.length; j++) {
			// System.out.print(labels[j] + ": ");
			for (int i = 0; i < edges[j].length; i++) {
				if (edges[j][i] > 0)
					System.out.println(labels[j] + " -> " + labels[i] + ":" + edges[j][i] + " ");
			}
			System.out.println();
		}
	}

	public int getUnvisitedNeighbor(int vertex, boolean[] visited) {
		// find an unvisited neighbor of a given vertex
		// if there exist multiple unvisited neighbors, return the first one found
		// if all neighbors are visited, return -1

		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0 && visited[i] == false)
				return i;
		}
		return -1;
	}

	public void dfs() {// DFS using stack

		System.out.println("DFS:");
		int n = edges.length;
		boolean visited[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			visited[i] = false;// Reset the visited matrix
		}

		// Pick the starting node randomly
		Random rand = new Random();
		int randNum = rand.nextInt(n);

		Stack<Integer> theStack = new Stack();

		// Visit the starting node
		visited[randNum] = true;
		System.out.println("Visited: " + labels[randNum]);
		theStack.push(randNum);

		while (!theStack.isEmpty()) {
			int neighbor = getUnvisitedNeighbor(theStack.peek(), visited);
			if (neighbor == -1) {
				// all neighbors are visited
				// pop the top vertex out
				theStack.pop();
			} else {
				// if there exists at least one unvisited neighbor
				visited[neighbor] = true;
				System.out.println("Visited: " + labels[neighbor]);
				theStack.push(neighbor);
			}
		}

	}

	public void bfs() {

		System.out.println("BFS:");
		int n = edges.length;
		boolean visited[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			visited[i] = false;// Reset the visited matrix
		}

		// Pick the starting node randomly
		Random rand = new Random();
		int randNum = rand.nextInt(n);

		// Instantiate Queue to hold
		Queue<Integer> bfsQueue = new LinkedList();

		// Visit the starting node
		visited[randNum] = true;
		System.out.println("Visited: " + labels[randNum]);
		bfsQueue.offer(randNum);

		// while Queue is not empty, more possible nodes to find
		while (!bfsQueue.isEmpty()) {
			int neighbor = getUnvisitedNeighbor(bfsQueue.peek(), visited);
			// if no more unvisited neighbors
			if (neighbor == -1) {
				// remove current head node
				bfsQueue.poll();
			} else {
				// else add visited neighbor to queue, mark as visited
				visited[neighbor] = true;
				System.out.println("Visited: " + labels[neighbor]);
				bfsQueue.offer(neighbor);
			}
		}

	}

	public static void main(String args[]) {

		// An example to create a graph using the Graph class
		final Problem14 t = new Problem14(6);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.setLabel(3, "D");
		t.setLabel(4, "E");
		t.setLabel(5, "F");
		t.addEdge(0, 1, 1);
		t.addEdge(0, 5, 1);
		t.addEdge(1, 2, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(1, 5, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(5, 4, 1);
		t.print();
		t.dfs();
		t.bfs();

		// Problem 10
		System.out.println("\n\nAdjList");
		int size = 6; // Graph Size
		LinkedList[] AdjList = new LinkedList[size]; // Array of type LinkedList
		
		// Fill in Array of new LinkedLists
		for (int index = 0; index < size; index++) {
			AdjList[index] = new LinkedList();
		}
		// A bit confused on how to implentment specifically the LinkList portion
		// of the AdjList for our given methods: bfs, dfs
		// given the methods are written specifcally for AdjMatrix
		// 
		// My AdjList utilizes an Array of LinkedLists
		// Each "label" is equal to the Array index
		// The LinkedList points to all edges/connections
		// Here is the List
		// 0 -> 1,2
		// 1 -> 2,3
		// 2 -> 3
		// 3 -> 4
		// 4 -> 0,5
		// 5 -> 
		AdjList[0].add(1); 
		AdjList[0].add(2);
		AdjList[1].add(2);
		AdjList[1].add(3);
		AdjList[2].add(3);
		AdjList[3].add(4);
		AdjList[4].add(0);
		AdjList[4].add(5);
		
		// Print AdjList
		for (int index = 0; index < AdjList.length; index++) {
			System.out.print(index + ":");
			System.out.println(AdjList[index].toString());
		}

	}

}
