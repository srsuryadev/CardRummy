import java.util.Scanner;

public class Driver {

	public static void main(String[] args){
		
		System.out.println("Choose level:\n1. Easy\n2. Medium\n");
		Scanner s = new Scanner(System.in);
		int level = s.nextInt();
		DiamondGame game = new DiamondGame(level);
		Deck deckOfDiamonds = new DiamondDeck();
		deckOfDiamonds.shuffle();
		
		for(int i =0; i < 13; i++){
			Card bidOn = deckOfDiamonds.drawCard();
			bidOn.display();
			Card cPlay = game.cPlayer.play(bidOn.getrank(), game.cPlayer.score, game.hPlayer.score);
			Card hPlay = game.hPlayer.play();
//			cPlay.display();
			game.evaluateBid(cPlay, hPlay, bidOn.getrank()+1);
			game.getScore();
			
		}
		
		game.winner();
	}

}
