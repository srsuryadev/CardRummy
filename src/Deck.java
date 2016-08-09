import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	ArrayList<Cards> deck;
	int size;
	int index_1,index_2;
	Cards temp;
	
	Deck(){
		for(int i = 0; i < 4; i++){
			for(int j = 0;j < 13; j++){
				Cards c = new Cards(i, j);
				deck.add(c);
			}
		}
		size = deck.size() - 1;
	}
	
	public void shuffle(){
		Random genRand = new Random();
		for(int i = 0; i < 100; i++){
            index_1 = genRand.nextInt( size );
            index_2 = genRand.nextInt( size );

            temp = (Cards) deck.get( index_2 );
            deck.set( index_2 , deck.get( index_1 ) );
            deck.set( index_1, temp );
		}
	}
	
	public int deckSize(){
		return deck.size()-1;
	}
	
	public Cards drawCard(){
		return deck.remove(deck.size()-1);
	}

}
