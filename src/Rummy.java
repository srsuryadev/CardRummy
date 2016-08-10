import java.util.Scanner;

public class Rummy {
	
	public static void main(String[] args){
		Deck deck;
		System.out.println("Enter the number of players");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
//		deck = new Deck();
		System.out.println("Enter type of packs:\n1.with joker\n2.without joker:");
		int ptype = s.nextInt();
		int pnum = 1;
		switch(ptype){
		case 1: 
			deck = new Deck(pnum, 1);
			deck.display();
			break;
		case 2:
			deck = new Deck(pnum, 0);
			deck.display();
			break;
		}
		
		
		
//		Hands[] hand = new Hands[n];
//		
//		hand = distrubuteCards(deck,n);
//		
//		for(int i = 0; i < n; i++){
//			hand[i].sortSuite();
//		}
//		checkHands(hand[0]);
		
	}
	
	public static Hands[] distrubuteCards(Deck deck,int n){
		deck.shuffle();
		Hands[] hand = new Hands[n];
		
		for(int i =0;i< n ;i++){
			hand[i] = new Hands();
		}
		for(int i = 0 ; i < 13 ; i++){
			for(int j = 0 ; j < n ; j++){
				hand[j].cards.add(deck.drawCard());
			}
		}
		return hand;
	}
	
	public boolean checkHands(Hands hand){
		boolean result = false;
		
		return result;
	}
	
	
	public int checkSeq(Hands hand){
		Hands h = new Hands();
		
		int numSeq = 0;
		for(int i = 0; i < 4; i++){
			int seqCount = 0;
			for(int j = 0; j < hand.cards.size()-1 ; j++){
				int s = hand.cards.get(j).getsuite();
				int r = hand.cards.get(j).getrank();
				int nextr = hand.cards.get(j+1).getrank();
				if(s == i){
					if(nextr == r + 1)
						seqCount++;
					else
						seqCount = 0;
				}
			}
			if(seqCount >= 3) 
				numSeq++;
		}
		return numSeq;
	}
}
