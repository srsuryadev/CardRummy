import java.util.Scanner;

public class pokerHandEval {
	
	//use strings to calculate rank diff
	// this.hand.sort(new Comparator<Card>(){
//	@Overide
//	public int compare(Card a, Card b){
//		return a.getSeq() - b.getSeq();
//	}
	// fullhouse "0x00 00x0" . contains(this.rankDiffStr) // diff not 1 then x
//	public static void main(String[] args){
//		Deck deck;
//		System.out.println("Enter the number of players");
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		s.close();
//		deck = new Deck();
//		Hand[] hand = new Hand[n];
//		
//		hand = distrubuteCards(deck,n);
//		
//		Hand handTest = new Hand();
//		Card c1 = new Card(0,1);
//		Card c2 = new Card(0,2);
//		Card c3 = new Card(0,3);
//		Card c4 = new Card(0,4);
//		Card c5 = new Card(0,5);
//		handTest.cards.add(c2);
//		handTest.cards.add(c3);
//		handTest.cards.add(c4);
//		handTest.cards.add(c5);
//		handTest.cards.add(c1);
//		
//		if(checkStraightFlush(handTest)){
//			System.out.println("Straight Flush");
//		}
//		
//		getType(hand);
//	}
	
	public static void getType(Hand[] hand){
		int n = hand.length;
		for(int i = 0; i < n; i++){
			hand[i].display();
			System.out.println();
			
			if(checkFlush(hand[i])){
				System.out.println("Flush");
			}

			if(checkStraight(hand[i])){
				System.out.println("Straight");
			}
			
			if(checkStraightFlush(hand[i])){
				System.out.println("Straight Flush");
			}
			if(checkNKind(hand[i], 4)){
				System.out.println("Four of a kind");
			}
			if(checkNKind(hand[i], 3)){
				System.out.println("Three of a kind");
			}
			
		}
	}
	
	public static Hand[] distrubuteCards(Deck deck,int n){
		deck.shuffle();
		Hand[] hand = new Hand[n];
		
		for(int i =0;i< n ;i++){
			hand[i] = new Hand();
		}
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < n ; j++){
				hand[j].cards.add(deck.drawCard());
			}
		}
		return hand;
	}
	
	public static boolean checkFlush(Hand hand){
		hand.sortSuite();
		int count = 1;
		int flushSize = 5;
		for(int j = 0; j < hand.cards.size()-1 ; j++){
			int s = hand.cards.get(j).getsuite();
			int nexts = hand.cards.get(j+1).getsuite();
			if(s == nexts){
				count++;
			}
		}
		if(count == flushSize)
			return true;
		return false;
					
	}

	public static boolean checkStraight(Hand hand){
		hand.sortRank();
		int numSeq = 1;
		int straightSize = 5;
		for(int j = 0; j < hand.cards.size()-1 ; j++){
			int r = hand.cards.get(j).getrank();
			int nextr = hand.cards.get(j+1).getrank();
			if(nextr == r + 1){
				numSeq++;
			}
		}
		if(numSeq == straightSize)
			return true;
		return false;
	}
	
	public static boolean checkStraightFlush(Hand hand){
		return checkFlush(hand) && checkStraight(hand);
	}
	
	public static boolean checkNKind(Hand hand, int n){
		hand.sortRank();
		int count = 0;
		for(int j = 0; j < hand.cards.size()-1 ; j++){
			int r = hand.cards.get(j).getrank();
			int nextr = hand.cards.get(j+1).getrank();
			if(r == nextr){
				count++;
			}
		}
		if(count == n)
			return true;
		return false;			
	}
	
	public static boolean checkFullHouse(Hand hand){
		hand.sortRank();
		int count [] = new int[13];	
		for(int j = 0; j < hand.cards.size() ; j++){
			int r = hand.cards.get(j).getrank();
			count[r]++;
		}
		boolean flag1=false , flag2=false;
		for(int i = 0; i < 13; i++){
			if(count[i] == 3){
				flag1 = true;
			}
			if(count[i] == 2){
				flag2 = true;
			}
		}
		return flag1 && flag2 ;
	}

}
