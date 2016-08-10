import java.util.Scanner;

public class Human extends Player{
	
	public Human(){
		this.score=0;
		this.hand=new SingleSuitHand(1);
	}
	
	public Card play(){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Card c = new Card(this.hand.cards.get(0).getsuite(),n);
		return c;
	}

}
