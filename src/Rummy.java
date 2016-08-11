import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class Rummy {
	
	public HashMap<Integer, List<Integer> > hmSuitFace;
	public HashMap<Integer, List<Integer> > hmFaceSuit;
	
	public Rummy(){
		hmSuitFace = new HashMap<Integer, List<Integer>>();
		hmFaceSuit = new HashMap<Integer, List<Integer>>();
	}
	
	public static void main(String[] args){
		Deck deck;
		System.out.println("Enter the number of players");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Enter type of packs:\n1.with joker\n2.without joker:");
		int ptype = s.nextInt();
		int pnum = 1;
		switch(ptype){
		case 1: 
			deck = new DeckWithJoker(pnum, 1);
			deck.display();
			break;
		}		
	}
	
	public boolean populateHashSF(List<Card> cards){
		for(int i = 0; i<cards.size(); i++){
			Card c = cards.get(i);
			List<Integer> f = new ArrayList<Integer>();
			if(hmSuitFace.containsKey(c.getsuite())){
				f = hmSuitFace.get(c.getsuite());
			}
			f.add(c.getrank());
			hmSuitFace.put(c.getsuite(), f);
		}
		return true;
	}
	
	public boolean populateHashFS(List<Card> cards){
		for(Card c: cards){
			List<Integer> s = new ArrayList<Integer>();
			if(hmFaceSuit.containsKey(c.getrank())){
				s = hmFaceSuit.get(c.getrank());
			}
			s.add(c.getsuite());
			hmFaceSuit.put(c.getrank(), s);
		}
		return true;
	}
	
	public List< List<Card> > getAllSequence(List<Card> cards){
		List< List<Card> > result = new ArrayList< List<Card>>();
		System.out.println("THE LIST SIZE"+ cards.size());
		this.populateHashSF(cards);
		for (Map.Entry<Integer, List<Integer> > entry : hmSuitFace.entrySet()) {
			List<Integer> list = null;
			list = entry.getValue();
			System.out.println("SIZE OF THE LIST::"+list.size());
			if(list.size() !=0){
				Collections.sort(list);
				System.out.println("LIST::"+list);
				for(int i = 0; i < list.size() ; i++){
					List<Card> lst = new ArrayList<Card>();
					lst.add(new Card(entry.getKey(),list.get(i)));
					for(int j = i+1; j<list.size();j++){
						System.out.println("PRINT THE SEQ::"+ lst);
						result.add(lst);
						lst.add(new Card(entry.getKey(),list.get(j)));
					}
				}
			}
		}
		for(int i =0;i<result.size(); i++){
			System.out.println("LIST OF THE RESULT:");
			System.out.println(result.get(i));
			for(int j =0; j<result.get(i).size(); j++){
				result.get(i).get(j).display();
			}
			System.out.println("+++++++++++++++++++++++++");
		}
		return result;
	}
	
	public List< List<Card> > getAllGroup(List<Card> cards){
		List< List<Card> > result = new ArrayList< List<Card>>();
		this.populateHashFS(cards);
		for (Map.Entry<Integer, List<Integer> > entry : hmFaceSuit.entrySet()) {
			List<Integer> list = null;
			if((list = entry.getValue()).size() !=0){
				Collections.sort(list);
				for(int i = 0; i < list.size() ; i++){
					List<Card> lst = new ArrayList<Card>();
					lst.add(new Card(entry.getKey(),list.get(i)));
					for(int j = i+1; j<list.size();j++){
						result.add(lst);
						lst.add(new Card(list.get(j),entry.getKey()));
					}
				}
			}
		}
		return result;
	}

	public boolean isRummyHand(List<Card> cards){
		
		if(cards.isEmpty()) return true;
		List< List<Card>> allSeq = this.getAllSequence(cards);
		allSeq.addAll(this.getAllGroup(cards));
		List<Card> copy = null;
		System.out.println("IS RUMMY");
		for(int i = 0; i<allSeq.size(); i++){
			List<Card> seq = allSeq.get(i);
			copy = new ArrayList(cards);
			if(cards.containsAll(seq)&&seq.size()>=3){
				copy.removeAll(seq);
				if(isRummyHand(copy)) return true;
			}
		}
		return false;
	}
	
	public static Hand[] distrubuteCards(Deck deck,int n){
		deck.shuffle();
		Hand[] hands = new Hand[n];
		for(int i =0;i< n ;i++){
			hands[i] = new Hand();
		}
		for(int i = 0 ; i < 13 ; i++){
			for(int j = 0 ; j < n ; j++){
				hands[j].cards.add(deck.drawCard());
			}
		}
		return hands;
	}
	
	public boolean checkHands(Hands hand){
		boolean result = false;
		
		return result;
	}
	
	public static boolean checkNKind(Hand hand, int n){
		hand.sortRank();
		int count = 0;
		for(int j = 0; j < hand.cards.size()-1 ; j++){
			int r = hand.cards.get(j).getrank();
			int nextr = hand.cards.get(j+1).getrank();
			if(r==-1||(r == nextr)|| nextr ==-1){
				count++;
			}
		}
		if(count == n)
			return true;
		return false;			
	}
	
	public int checkSeq(Hand hand){
		Hand h = new Hand();
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

	
