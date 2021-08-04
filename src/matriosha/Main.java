package matriosha;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static Ground ground;
	private static Node startNode;
	private static List<Node> maxPath = null;

	public static void main(String[] args) {
		readText();
		
		startNode = ground.getNode(0, 0);
		startNode.setStartNode(true);
		doSearch(startNode, null);
		System.out.println("max=" + count(maxPath));
		for (Node node : maxPath) {
			System.out.print("  --> " + node.getWorth());
		}
	}

	@SuppressWarnings("resource")
	private static void readText() {
		ground = new Ground();
		try {
			File file = new File("/Users/zhangll/IntelliJIDEAProjects/StudyWithKotlin/src/matriosha/test.txt");
			FileReader reader = new FileReader(file);
	        int fileLen = (int)file.length();
	        char[] chars = new char[fileLen];
	        reader.read(chars);
	        String txt = String.valueOf(chars);
	        splitString(txt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void splitString(String str) {
		String[] stry = str.split("\n");
		List<Node> nodes = new ArrayList<Node>();
		ground.setHeight(stry.length);
		for(int i = 0; i < stry.length; i++) {
			String[] strx = stry[i].split(" ");
			ground.setWidth(strx.length);
			for(int j = 0; j < strx.length; j++) {
				Node node = new Node();
				node.setX(j);
				node.setY(i);
				node.setWorth(Integer.parseInt(strx[j].trim()));
				nodes.add(node);
			}
		}
		ground.setNodes(nodes);
		
		for ( Node node : ground.getNodes() ) {
			node.setRelation(ground);
		}
	}
	
	private static void doSearch(Node node, Node lastNode){
		System.out.println("at node " + node.getWorth());
		if(lastNode != null) {
			lastNode.setNextNode(node);
		}
		node.setLastNode(lastNode);
		
		if(node.getPossibleNodes().size() == 0) {
			saveBigger(getPath(startNode));
		} else {
			for(Node nextNode : node.getPossibleNodes()) {
				doSearch(nextNode, node);
				nextNode.setLastNode(null);
				node.setNextNode(null);
			}
		}
	}
	
	private static List<Node> getPath(Node node) {
		List<Node> path = new ArrayList<Node>();
		path.add(node);
		if(node.getNextNode() != null) {
			path.addAll(getPath(node.getNextNode()));
		}
		return path;
	}
	
	private static void saveBigger(List<Node> nodes) {
		if(maxPath == null) {
			maxPath = nodes;
		}else {
			if(count(nodes) > count(maxPath)) {
				maxPath = nodes;
			}
		}
	}
	
	private static int count(List<Node> nodes) {
		int count = 0;
		for(Node node : nodes) {
			count += node.getWorth();
		}
		return count;
	}
}