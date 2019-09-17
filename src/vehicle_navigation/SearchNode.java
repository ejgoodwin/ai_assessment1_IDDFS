package vehicle_navigation;

import java.util.ArrayList;

public class SearchNode {
	
	private int x_location;
	private int y_location;
	private int depth;
	public ArrayList<SearchNode> newNodes;
	
	int[][] grid1 = new int [][] {
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
	
	public SearchNode(int x, int y, int depthIn) {
		x_location = x;
		y_location = y;
		depth = depthIn;
		this.newNodes = new ArrayList<>();
	}
	
	public boolean checkGoal() {
		boolean goalReached = false;
		if (grid1[x_location][y_location] == 3) {
			goalReached = true;
		}
		return goalReached;
	}
	
	public ArrayList<SearchNode> expandNode(int depth) {
		// Node north = [x-1][y]
		if( (x_location - 1) >= 0 ) {
			SearchNode north = new SearchNode(x_location -1, y_location, depth);
			newNodes.add(north);
		}
		
		// Node west = [x][y-1]
		if( (y_location - 1 >= 0) ) {
			SearchNode west = new SearchNode(x_location, y_location -1, depth);
			newNodes.add(west);
		}
		// Node south = [x+1][y]
		if( (x_location + 1) <= 14) {
			SearchNode south = new SearchNode(x_location +1, y_location, depth);
			newNodes.add(south);
		} 
		// Node east = [x][y+1]
		if( (y_location + 1) <= 14) {
			SearchNode east = new SearchNode(x_location, y_location +1, depth);
			newNodes.add(east);
		}

		// Return list
		return this.newNodes;
	}
	
	public int getDepthLevel() {
		return depth;
	}
	
	public void setDepthLevel(int depthLevel) {
		this.depth = depthLevel;
	}
	
	public void getCoords() {
		System.out.println("(" + x_location + ", " + y_location + ")" );
	}
	
	@Override
	public String toString() {
		return "(" + x_location + ", " + y_location + ")";
	}

}
