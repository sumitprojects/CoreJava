import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node {
	private int key;
	private int value;
	private ArrayList<Node> nodes = new ArrayList<>();
	
	Node () {
	}
	
	Node (int key, int value, Node n) {
		this.key = key;
		this.value = value;
		this.nodes.add(n);
	}
	
	int getKey () {
		return key;
	}
	
	void setKey (int key) {
		this.key = key;
	}
	
	int getValue () {
		return value;
	}
	
	void setValue (int value) {
		this.value = value;
	}
	
	void add (Node n) {
		this.nodes.add(n);
	}
	
	boolean equals (Node o) {
		return (o.getKey() == this.getKey() && o.getValue() == this.getValue()) || (o.getKey() == this.getValue() && o.getValue() == this.getKey());
	}
	
	ArrayList<Node> getNodes () {
		return nodes;
	}
	
	@Override
	public String toString () {
		return "\n Node =>" +
				"key=" + key +
				", value=" + value + "\t" +
				"List" + nodes +
				'\n';
	}
}

public class TestClass {
	private Set<Integer> data = new HashSet<>();
	
	public static void main (String[] args) {
		int nLen, qLen;
		ArrayList<Node> nodeList = new ArrayList<>(), pathList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		TestClass testClass = new TestClass();
		/*
		 * scanning the node value
		 * */
		nLen = sc.nextInt();
		for (int i = 0; i < nLen; i++) {
			Node nodes = new Node();
			nodes.setKey(i);
			nodes.setValue(sc.nextInt());
			nodeList.add(nodes);
		}
		try {
			for (int i = 0; i < (nLen - 1); i++) {
				int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
				try {
					if (x > y) {
						int temp = x;
						x = y;
						y = temp;
					}
					nodeList.get(x).add(nodeList.get(y));
				} catch (Exception e) {
				}
			}
			System.out.println(nodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		qLen = sc.nextInt();
		for (int i = 0; i < (qLen); i++) {
			int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
			if (x > y) {
				int temp = x;
				x = y;
				y = temp;
			}
			System.out.println(testClass.findDistinctValue(nodeList, x, y));
			testClass.data.clear();
		}
	}
	
	private int findDistinctValue (ArrayList<Node> nodeList, int x, int y) {
		try {
			for (int i = 0; i < nodeList.size(); i++) {
				if (nodeList.get(i).getKey() == x) {
					System.out.println("Outer " + nodeList.get(i).getValue());
					data.add(nodeList.get(i).getValue());
					for (int j = 0; j < nodeList.get(i).getNodes().size(); j++) {
						if (nodeList.get(i).getNodes().get(j).getKey() == y) {
							data.add(nodeList.get(i).getNodes().get(j).getValue());
							System.out.println(nodeList.get(i).getNodes().get(j).getValue());
						}
					}
				} else {
					findDistinctValue(nodeList.get(i).getNodes(), x, y);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return data.size();
	}
}