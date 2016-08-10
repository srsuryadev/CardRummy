import java.util.ArrayList;
import java.util.Random;

public abstract class Deck {
	
	ArrayList<Card> deck;
	int size;
	int index_1,index_2;
	Card temp;
	
	Deck(){
		deck = new ArrayList<Card>();
	}
	
	public void shuffle(){
		Random genRand = new Random();
		int size = deck.size();
		for(int i = 0; i < 100; i++){
            index_1 = genRand.nextInt( size );
            index_2 = genRand.nextInt( size );

            temp = (Card) deck.get( index_2 );
            deck.set( index_2 , deck.get( index_1 ) );
            deck.set( index_1, temp );
		}
	}
	
	public int deckSize(){
		return deck.size()-1;
	}
	
	public void display(){
		for(int j = 0; j < deck.size() ; j++){
			deck.get(j).display();
			}
	}
	
	public Card drawCard(){
		return deck.remove(deck.size()-1);
	}

}
