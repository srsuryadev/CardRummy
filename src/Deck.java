import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Deck {
	
	ArrayList<Card> deckOfCards;
	pack[] deckOfPacks;
	int size;
	int index_1,index_2;
	Card temp;
	
	Deck(){
		deckOfPacks = new pack[0];
	}
	
	Deck(int pnum, int jnum){
		this.deckOfCards = new ArrayList<Card>();
		System.out.println("DECK");
		if(jnum == 0){
			this.deckOfPacks = new packWithoutJoker[pnum];
			System.out.println("DECK WITHOUT JOKER");
			for(int i = 0; i < pnum; i++){
				this.deckOfPacks[i] = new packWithJoker(jnum);
				System.out.println("PACK SIZE::"+this.deckOfPacks[i].p.size());
			}
		}
		else {
			this.deckOfPacks = new packWithJoker[pnum];
			for(int i = 0; i < pnum; i++){
				this.deckOfPacks[i] = new packWithJoker(jnum);
				System.out.println("PACK SIZE::"+this.deckOfPacks[i].p.size());
			}
		}
		for(int i = 0; i < pnum; i++){
			this.deckOfCards.addAll(this.deckOfPacks[i].p);
		}	
		System.out.println("THE SIZE OF THE DECK"+ this.deckOfCards.size());
			
	}
	
	public void setUp(){
		for(int i = 0; i  < 4; i++){
			for(int j = 0;j < 13; j++){
				Card c = new Card(3, j);
				this.deckOfCards.add(c);
			}
		}
	}
	
	public void shuffle(){
		Random genRand = new Random();
		int size = this.deckOfCards.size();
		for(int i = 0; i < 100; i++){
            index_1 = genRand.nextInt( size );
            index_2 = genRand.nextInt( size );

            this.temp = (Card) this.deckOfCards.get( index_2 );
            this.deckOfCards.set( index_2 , this.deckOfCards.get( index_1 ) );
            this.deckOfCards.set( index_1, temp );
		}
	}
	
	public int deckSize(){
		return this.deckOfCards.size()-1;
	}
	
	public void display(){
		for(int j = 0; j < deckOfCards.size() ; j++){
			this.deckOfCards.get(j).display();
			}
	}
	
	public Card drawCard(){
		return this.deckOfCards.remove(this.deckOfCards.size()-1);
	}

}