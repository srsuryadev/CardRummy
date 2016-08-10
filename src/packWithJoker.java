
public class packWithJoker extends pack {
	
	packWithJoker(){
		for(int i = 0; i < 4; i++){
			for(int j = 0;j < 13; j++){
				Card c = new Card(i, j);
				pack.add(c);
			}
		}
		Card joker = new Card(0);
		pack.add(joker);
		pack.add(joker);
	}

}
