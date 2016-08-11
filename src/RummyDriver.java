import java.util.ArrayList;
import java.util.List;
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
		/*hands = rummy.distrubuteCards(d, playernum);
		for(int i = 0; i < playernum; i++){
			hands[i].sortSuite();
			System.out.println("HAND 1:");
			hands[i].display();
		}
		*/
		
		List<Card> lst = new ArrayList<Card>();
		lst.add(new Card(1,2));
		lst.add(new Card(1,3));
		lst.add(new Card(1,4));
		lst.add(new Card(1,5));

		
		System.out.println("IS LST RUMMY:"+rummy.isRummyHand(lst));
		
		List< List<Card> > result = rummy.getAllSequence(lst);
		for(int i = 0;i< result.size(); i++ ){
			System.out.println("SEQ"+i);
			new Hand(result.get(i)).display();
			
			//System.out.println(rummy.isRummyHand(result.get(i)));
		}
		
	}

}
