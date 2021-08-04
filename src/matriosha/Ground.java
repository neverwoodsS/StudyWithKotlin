package matriosha;

import java.util.List;

public class Ground {
	
	private int width = 5;
	private int height = 5;
	
	private List<Node> nodes;

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public Node getNode(int x, int y) {
		return nodes.get(y * width + x);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}