package vehicle_navigation;

import java.util.ArrayList;
import java.util.Stack;


public class IDSearch {
	
	static boolean targetFound = false;
	
	public static void iterativeDeepening(SearchNode startNode) {
		// Calls depthLimitedSearch repeatedly
		int depth = 0;
		
		while(!targetFound) {
			System.out.println("Run DLS \n");
			depthLimitedSearch(startNode, depth);
			depth = depth + 1;
		}
		
	}
	
	public static void depthLimitedSearch(SearchNode startNode, int depth) {

		// Frontier
		Stack<SearchNode> frontier = new Stack<SearchNode>();
		// Explored
		ArrayList<SearchNode> explored = new ArrayList<SearchNode>();
		
		// Variable to store the node that is being checked and expanded
		SearchNode current = null;
		System.out.println("Current: " + current);
		
		// Add initial state to frontier
		frontier.add(startNode);
		
		System.out.println("DEPTH: " + depth);
		
		do {
			// Check that at least 1 node is in the frontier
			if(frontier.isEmpty()) {
				System.out.println("Failure");
				return;
			}
			
			// Set current state to first queue element
			current = frontier.pop();
			System.out.println("Frontier: " + frontier);
			System.out.println("Current: " + current);
			
			// Add this node to the explored list
			explored.add(current);
			System.out.println("Explored: " + explored);

			
			if(current.checkGoal()) {
				System.out.println("Success! " + current);
				targetFound = true;
				return;
			}
			// If the depth of the current node is greater than or equal to the depth limit, stop this loop and go back to iterativeDeepening()
			if (current.getDepthLevel() >= depth) {
				continue;
			}
			// Expand if the node is not a traffic jam
			System.out.println("Traffic jam: " + current.checkTrafficJam());
			if(!current.checkTrafficJam()) {
				
				ArrayList<SearchNode> expandedNodes = current.expandNode(depth);
				System.out.println("Expanded Nodes: " + expandedNodes);
				for (SearchNode node : expandedNodes) {
					
					if (!frontier.toString().contains(node.toString()) 
							&& !explored.toString().contains(node.toString())) {
						frontier.push(node);
					}
					
				}
			}
			
			System.out.println("depth: " + depth + "\n");
		} while (!frontier.empty());
	}

	public static void main(String[] args) {
		
		SearchNode startNode = new SearchNode(13,7, 0);
		iterativeDeepening(startNode);

	}

}
