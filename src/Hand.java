import java.util.ArrayList;

public class Hand{
	ArrayList<Card> cards;
	
	Hand(){
		cards = new ArrayList<Card>();
	}
	
	public void sortSuite(){
		ArrayList<Card> cardSuite = new ArrayList<Card>();
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < cards.size() ; j++){
				int s = cards.get(j).getsuite();
				if(s == i){
					cardSuite.add(cards.get(j));
				}
			}
		}
		cards = cardSuite;
	}
	
	public void sortRank(){
		ArrayList<Card> cardSuite = new ArrayList<Card>();
			for(int k = 0; k < 13; k++){
			for(int j = 0; j < cards.size() ; j++){
				int r = cards.get(j).getrank();
				if( r == k ){
					cardSuite.add(cards.get(j));
				}
			}
		}
		cards = cardSuite;
	}
	
	public void addCard(Card c){
		cards.add(c);
	}
	
	public void display(){
		for(int j = 0; j < cards.size() ; j++){
			cards.get(j).display();
			}
	}
}
