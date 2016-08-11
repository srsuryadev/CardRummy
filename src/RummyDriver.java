import java.util.Scanner;

public class RummyDriver {
static Deck d;
	
	public static void main(String[] args){

		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of players");
		int playernum = 3;
		
		System.out.println("Enter the number of packs");
		int pnum = 3;
		
		System.out.println("Enter type of packs:\n1.with joker\n2.without joker:");
		int ptype = 2;
		int jnum = 2;
		
		
		d = new DeckWithJoker(pnum, jnum);
		d.display();
	
		Hand[] hands = new Hand[playernum];	
		Rummy rummy = new Rummy();
		hands = rummy.distrubuteCards(d, playernum);
		for(int i = 0; i < playernum; i++){
			hands[i].sortSuite();
			System.out.println("HAND 1:");
			hands[i].display();
		}
		
	}

}