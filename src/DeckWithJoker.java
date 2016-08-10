import java.util.ArrayList;

public class DeckWithJoker extends Deck {
	
	DeckWithJoker(int n, int ptype){
		for(int j = 0; j < n; j++){
			if(ptype == 1){
				packWithJoker pj = new packWithJoker();
				ArrayList<Cards> deck = new ArrayList<Cards>();
				deck.addAll(pj.pack);
			}
			else{
				packWithoutJoker pwj = new packWithoutJoker();
				ArrayList<Cards> deck = new ArrayList<Cards>();
				deck.addAll(pwj.pack);
			}
		}
	}

}
