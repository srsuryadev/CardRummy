import java.util.ArrayList;
import java.util.List;

public class Computer extends Player{
	ArrayList<Boolean> myHand;
	ArrayList<Boolean> playedCards;
	Strategy strategy;
	int level;
	
	public Computer(int level){
		this.score = 0;
		this.hand = new SingleSuitHand(2);
		this.level = level;
		if(this.level == 0){
			this.strategy = new SimpleStrategy();
		}
		else if(this.level == 1){
			this.strategy = new MediumStrategy();
		}
		else{
			this.strategy = new DifficultStrategy();
		}
		this.myHand = new ArrayList<Boolean>(13);
		this.playedCards = new ArrayList<Boolean>(13);
		
	}
	
	public Card play(int bidOn, float cScore, float hScore){
		int cardRank = this.strategy.nextMove(bidOn,myHand, playedCards, cScore, hScore);
		Card playCard = new Card(this.hand.cards.get(0).getsuite(), cardRank);
		return playCard;
		
	}

}
