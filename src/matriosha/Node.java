package matriosha;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int x;
	private int y;
	
	private int worth;
	
	private Node lastNode;
	private Node nextNode;
	
	private List<Node> touchableNodes;
	
	private Ground ground;
	
	private boolean isStartNode;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWorth() {
		return worth;
	}

	public void setWorth(int worth) {
		this.worth = worth;
	}

	public Node getLastNode() {
		return lastNode;
	}

	public void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public Ground getGround() {
		return ground;
	}

	public void setGround(Ground ground) {
		this.ground = ground;
	}

	public void setRelation(Ground ground){
		this.ground = ground;
		touchableNodes = new ArrayList<Node>();
		if ( x > 0) {
			touchableNodes.add( ground.getNode( x - 1, y ) );
		}
		
		if ( x < ground.getWidth() - 1) {
			touchableNodes.add( ground.getNode( x + 1, y ) );
		}
		
		if ( y > 0) {
			touchableNodes.add( ground.getNode( x, y - 1 ) );
		}
		
		if ( y < ground.getHeight() - 1) {
			touchableNodes.add( ground.getNode( x, y + 1 ) );
		}
	}
	
	public boolean isStartNode() {
		return isStartNode;
	}

	public void setStartNode(boolean isStartNode) {
		this.isStartNode = isStartNode;
	}

	public List<Node> getPossibleNodes() {
		List<Node> possibleNodes = new ArrayList<Node>();
		for (Node node : touchableNodes) {
			if (node.getLastNode() == null && !node.isStartNode()) {
				if(node.getWorth() > getLastWorth(this) || node.getWorth() == 0) {
					possibleNodes.add(node);
				}
			}
		}
		return possibleNodes;
	}
	
	private int getLastWorth(Node node) {
		if (node.getWorth() == 0) {
			return getLastWorth(node.getLastNode());
		} else {
			return node.getWorth();
		}
	}
}