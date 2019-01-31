import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PUBG implements Runnable {
	static {
		System.out.println("              ________    __      __     __________    ___________ ");
		System.out.println("             |   __   |  |  |    |  |   |   ____   |  |   ________|");
		System.out.println("             |  |  |  |  |  |    |  |   |  |   |   |  |  |");
		System.out.println("             |  |__|  |  |  |    |  |   |  |__ /  /   |  |    ____");
		System.out.println("             |   _____|  |  |    |  |   |   __   |    |  |   |__  |");
		System.out.println("             |  |        |  |    |  |   |  |   \\  \\   |  |     |  |");
		System.out.println("             |  |        |  |____|  |   |  |____|  |  |  |_____|  |");
		System.out.println("             |__|        |__________|   |__________|  |___________|");
	}
	
	private int counter = 0;
	private Squad[] mySquad = new Squad[5];
	private Random random = new Random();
	private int totalMatches, winnerSquad_Id;
	private PUBG gameObject;
	private boolean gameplay = true;
	
	PUBG () {
	}
	
	public static void main (String[] args) {
		PUBG pubg = new PUBG();
		pubg.setGameObject(pubg);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		pubg.game();
		try {
			System.out.println("\n\t\t\t\tPlease wait while game is loading.\n");
			System.out.print("\t\t\t\t");
			for (int i = 0; i < 45; i++) {
				Thread.sleep(100);
				System.out.print("|");
			}
		} catch (InterruptedException ignored) {
		
		}
		System.out.println("\n\n\t\t\t\tGame is Staring.");
		System.out.println("\n\n Total squad and players information before game.......\n");
		pubg.display();
		
		
		do {
			try {
				executor.execute(pubg);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (pubg.getGameStatus());
		executor.shutdown();
		while (!executor.isTerminated()) {
			//   executor.shutdown();
		}
		System.out.println("\n\n Total squad and players information before game.......\n");
		pubg.display();
		System.out.println("\n\n\n\n Winner Winner Chicken Dinner.......\n\n");
		pubg.finalWinner();
	}
	
	void game () {
		squadCreator();
	}
	
	private void winDisplay (Player winner, Player losser) {
		System.out.print("\t\t\t\t");
		for (int i = 0; i < 45; i++) {
			System.out.print("-");
		}
		System.out.println("\n\t\t\t\t|\t" + winner.name + " VS " + losser.name + "\t|");
		System.out.println("\t\t\t\t|\t\t" + winner.getLife() + "\t\t\t |\t\t\t" + losser.playerLifeStatus() + "\t\t\t|");
		System.out.print("\t\t\t\t");
		for (int i = 0; i < 45; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	void display () {
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (Squad sq : mySquad) {
			System.out.println(sq);
		}
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println("Total matches played : " + totalMatches);
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
		System.out.println("\n");
	}
	
	void finalWinner () {
		System.out.println(mySquad[winnerSquad_Id]);
	}
	
	private int randomGenerator () {
		int randomData = 0;
		try {
			randomData = random.nextInt(15);
			Thread.sleep(10);
		} catch (Exception e) {
			System.out.println("Random ERR : " + e.getMessage());
		}
		return randomData;
	}
	
	private boolean win () {
		int winCounter = 0;
		for (int i = 0; i < mySquad.length; i++) {
			if (mySquad[i].aliveSquad) {
				winCounter++;
				winnerSquad_Id = i;
			}
		}
		return winCounter == 1;
	}
	
	private void fight (Pair p) {
		try {
			do {
				int attack1 = randomGenerator(), attack2 = randomGenerator();
				if (attack1 < attack2) {
					p.player1.life = p.player1.life - (attack2 - attack1);
				} else if (attack1 > attack2) {
					p.player2.life = p.player2.life - (attack1 - attack2);
				}
				if (p.player1.life <= 0 && p.player2.life > 0) {
					try {
						winDisplay(p.player2, p.player1);
						updatePlayerStatus(p.player1.uId, false, false, 0);
						squadAliveStatus(p.player1.squadId);
						updatePlayerStatus(p.player2.uId, true, false, p.player2.life);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					totalMatches++;
					break;
				} else if (p.player2.life <= 0 && p.player1.life > 0) {
					try {
						winDisplay(p.player1, p.player2);
						updatePlayerStatus(p.player1.uId, true, false, p.player1.life);
						updatePlayerStatus(p.player2.uId, false, false, 0);
						squadAliveStatus(p.player2.squadId);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					totalMatches++;
					break;
				}
			} while ((p.player1.life > 0) || (p.player2.life > 0));
		} catch (Exception e) {
			System.out.println("Fight Error : " + e.getMessage());
		}
	}
	
	private Pair checkingPlayers () {
		Player p1 = null, p2 = null;
		int sqid = 0;
		outer:
		for (Squad aMySquad : mySquad) {
			if (aMySquad.aliveSquad) {
				for (int j = 0; j < aMySquad.squadMembers.length; j++) {
					if (aMySquad.squadMembers[j].alive && !aMySquad.squadMembers[j].fightMode) {
						p1 = aMySquad.squadMembers[j];
						sqid = aMySquad.squadMembers[j].squadId - 1;
						break outer;
					}
				}
			}
		}
		outer1:
		for (int i = 0; i < mySquad.length; i++) {
			if (mySquad[i].aliveSquad) {
				if (i == sqid && p1 != null) {
					continue;
				}
				for (int j = 0; j < mySquad[i].squadMembers.length; j++) {
					if (mySquad[i].squadMembers[j].alive && !mySquad[i].squadMembers[j].fightMode) {
						p2 = mySquad[i].squadMembers[j];
						break outer1;
					}
				}
			}
		}
		return new Pair(p1, p2);
	}
	
	private void updatePlayerStatus (int u_Id, boolean aliveStatus, boolean fight_Mode, int lifeUpdate) {
		outer3:
		for (Squad aMySquad : mySquad) {
			for (int j = 0; j < aMySquad.squadMembers.length; j++) {
				if (aMySquad.squadMembers[j].uId == u_Id) {
					aMySquad.squadMembers[j].alive = aliveStatus;
					aMySquad.squadMembers[j].fightMode = fight_Mode;
					if (!fight_Mode) {
						aMySquad.squadMembers[j].life = lifeUpdate;
					}
					break outer3;
				}
			}
		}
	}
	
	private void squadCreator () {
		int newRandom, countPlayer = 0;
		int MAX_PLAYER_LIMIT = 20;
		do {
			if (counter >= 5) {
				this.mySquad = Arrays.copyOf(mySquad, mySquad.length + 1);
			}
			do {
				newRandom = random.nextInt(3) + 1;
			} while (countPlayer + newRandom > MAX_PLAYER_LIMIT);
			countPlayer += newRandom;
			mySquad[counter++] = new Squad(counter, "squad-" + counter, newRandom);
		} while (countPlayer < MAX_PLAYER_LIMIT);
	}
	
	private void squadAliveStatus (int squadId) {
		int counterDead = 0;
		for (Player p : mySquad[squadId - 1].squadMembers) {
			if (!p.alive) {
				counterDead++;
			}
		}
		if (counterDead == mySquad[squadId - 1].squadMembers.length) {
			mySquad[squadId - 1].squadAliveToogle();
		}
	}
	
	@Override
	public void run () {
		Pair p;
		try {
			if (!win()) {
				p = checkingPlayers();
				if (p.player1 != null && p.player2 != null && p.player1.alive && p.player2.alive && !p.player1.fightMode && !p.player2.fightMode) {
					updatePlayerStatus(p.player1.uId, true, true, 100);
					updatePlayerStatus(p.player2.uId, true, true, 100);
					fight(p);
					Thread.sleep(1000);
				}
			} else {
				gameObject.gameplay = false;
				Thread.currentThread().interrupt();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void setGameObject (PUBG gameObject) {
		this.gameObject = gameObject;
	}
	
	boolean getGameStatus () {
		return gameObject.gameplay;
	}
	
	private static class Pair {
		private Player player1, player2;
		
		Pair (Player player1, Player player2) {
			this.player1 = player1;
			this.player2 = player2;
		}
	}
	
	static class Squad {
		private int squadId;
		private String squadName;
		private Player[] squadMembers;
		private boolean aliveSquad = true;
		
		Squad (int squadId, String squadName, int squadMembers) {
			this.squadId = squadId;
			this.squadName = squadName;
			this.playerCreator(squadMembers);
		}
		
		private void playerCreator (int squadMembersLength) {
			this.squadMembers = new Player[squadMembersLength];
			for (int i = 0; i < squadMembersLength; i++) {
				this.squadMembers[i] = new Player(i + 1, this.squadName + " player-" + (i + 1), this.squadId);
			}
		}
		
		private void squadAliveToogle () {
			aliveSquad = !aliveSquad;
		}
		
		@Override
		public String toString () {
			return "Squad[" +
					"squadId=" + squadId +
					", squadName='" + squadName + '\'' +
					", squadLength " + squadMembers.length +
					",\naliveSquad=" + aliveSquad +
					",\nsquadMembers=\n" + Arrays.toString(squadMembers) +
					']' + "\n";
		}
	}
	
	static class Player {
		private static int counterId = 1;
		private final int uId;
		private boolean alive = true;
		private int id;
		private String name;
		private int life = 100;
		private boolean fightMode = false;
		private int squadId;
		
		Player (int id, String name, int squadId) {
			this.id = id;
			this.name = name;
			this.squadId = squadId;
			this.uId = counterId++;
		}
		
		int getLife () {
			return life;
		}
		
		int playerLifeStatus () {
			return (life <= 0) ? 0 : this.life;
		}
		
		@Override
		public String toString () {
			return "Player{" +
					"alive=" + alive +
					", id=" + id +
					", name='" + name + '\'' +
					", life=" + playerLifeStatus() +
					", fightMode=" + fightMode +
					", squadId=" + squadId +
					",unique id=" + this.uId +
					'}' + "\n";
		}
	}
	
}

