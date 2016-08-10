
public class DiamondGame {
	public Computer cPlayer;
	public Human hPlayer;
	int level;
	
	DiamondGame(int level){
		this.level = level;
		this.cPlayer = new Computer(this.level);
		this.hPlayer = new Human();
		
	}
	
	public  void evaluateBid(Card cPlay,Card hPlay, int bidRank){
		bidRank += 1;
		if(cPlay.getrank() > hPlay.getrank()){
			this.cPlayer.score += (float) bidRank;
		}
		else if(cPlay.getrank() == hPlay.getrank()){
			this.cPlayer.score += (float) bidRank / 2;
			this.hPlayer.score += (float) bidRank / 2;
		}
		else this.hPlayer.score += (float) bidRank;
	}
	
	public float scoreDiff(){
		return this.cPlayer.score-this.hPlayer.score;
	}
	
	public void getScore(){
		System.out.println("cScore" + this.cPlayer.score);
		System.out.println("hScore" + this.hPlayer.score);
	}
	
	public void winner(){
		if(this.cPlayer.score > this.hPlayer.score)
			System.out.println("Computer");
		else
			System.out.println("human Player");
	}

}
