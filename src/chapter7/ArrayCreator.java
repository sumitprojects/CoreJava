package chapter7;

public class ArrayCreator {
	final int[] cardSimbols = new int[]{0x2660, 0x2665, 0x2666, 0x2663};
	final int[] cardNumbers = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	final int SIZE = 3;
	ArrayCreator[] arrayCreator;
	String name = "player";
	int cardSimbol = 0, cardNumber = 0;
	int counter;
	
	public ArrayCreator () {
	}
	
	public ArrayCreator (int size) {
		arrayCreator = new ArrayCreator[size];
	}
	
	public ArrayCreator (int cardSimbol, int cardNumber) {
		this.cardSimbol = cardSimbol;
		this.cardNumber = cardNumber;
	}
	
	public ArrayCreator (String name) {
		arrayCreator = new ArrayCreator[SIZE];
		this.name = name;
	}
	
	public static void main (String[] args) {
		ArrayCreator[] players = new ArrayCreator[5];
		for (int i = 0; i < players.length; i++) {
			players[i] = new ArrayCreator("player " + (i + 1));
		}
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].name);
			for (int j = 0; j < players[i].arrayCreator.length; j++) {
				players[i].add(new ArrayCreator(players[i].cardSimbols[0], players[i].cardNumbers[0]));
				System.out.println(players[i].toString());
			}
		}
	}
	
	public boolean add (ArrayCreator arrayCreator) {
		if (counter < SIZE) {
			this.arrayCreator[counter++] = arrayCreator;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString () {
		return "ArrayCreator{" +
				"name='" + name + '\'' +
				", cardSimbol=" + cardSimbol +
				", cardNumber=" + cardNumber +
				'}';
	}
}