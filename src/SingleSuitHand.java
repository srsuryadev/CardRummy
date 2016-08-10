
public class SingleSuitHand extends Hand{
	
	SingleSuitHand(int suit){
		for(int j = 0;j < 13; j++){
			Card c = new Card(suit, j);
			cards.add(c);
		}
	}

}
