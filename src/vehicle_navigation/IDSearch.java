package vehicle_navigation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class IDSearch {
	
	static boolean targetFound = false;
	
	public static void iterativeDeepening(SearchNode startNode) {
		// Contains main loop
		// Calls depthLimitedSearch repeatedly
		int depth = 0;
		
		while(!targetFound) {
			System.out.println("Run DLS \n");
			depthLimitedSearch(startNode, depth);
			depth = depth + 1;
		}
//		depthLimitedSearch(startNode, 8);
		
	}
	
	public static void depthLimitedSearch(SearchNode startNode, int depth) {
		// Implement depth-first graph search
		
		
		// Needs frontier
		Stack<SearchNode> frontier = new Stack<SearchNode>();
		// Needs explored
		ArrayList<SearchNode> explored = new ArrayList<SearchNode>();
		
		// Variable to store the node that is being checked and expanded
		SearchNode current;
		
		// Add initial state to frontier
		frontier.add(startNode);
		System.out.println("Frontier: " + frontier);
		
		do {
			System.out.println("DEPTH: " + depth);
			// Check that at least 1 node is in the frontier
			if(frontier.isEmpty()) {
				System.out.println("Failure");
				return;
			}
			
			// Set current state to first queue element
			current = frontier.pop();
			System.out.println("Current: " + current);
//			current.getCoords();
			
			// Add this node to the explored list
			explored.add(current);
			System.out.println("Explored: " + explored);
			
			
			// Expand Node
//			startNode.expandNode();
//			frontier.addAll(current.expandNode(depth));
			

			
			if(current.checkGoal()) {
				System.out.println("Success! " + current);
				targetFound = true;
				return;
			}
			if (current.getDepthLevel() >= depth) {
				continue;
			}
			ArrayList<SearchNode> expandedNodes = current.expandNode(depth);
			System.out.println("Expanded Nodes: " + expandedNodes);
			for (SearchNode node : expandedNodes) {
				
				if (frontier.toString().contains(node.toString()) || explored.toString().contains(node.toString())) {
					continue;
				} else {
					frontier.push(node);
				}
//				System.out.print("Frontier string: " + frontier.toString().contains(node.toString()));
				
//				System.out.println("Node depth: " + node.getDepthLevel());
			}
			System.out.println("New Frontier: " + frontier + "\n");
			
		} while (!frontier.isEmpty());
		
//		System.out.println(startNode);
	}

	public static void main(String[] args) {
		
		SearchNode startNode = new SearchNode(2,3, 0);
		iterativeDeepening(startNode);

	}

}
